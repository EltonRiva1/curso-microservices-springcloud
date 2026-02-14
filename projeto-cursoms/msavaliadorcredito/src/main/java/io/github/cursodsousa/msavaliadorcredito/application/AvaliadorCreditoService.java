package io.github.cursodsousa.msavaliadorcredito.application;

import feign.FeignException;
import io.github.cursodsousa.msavaliadorcredito.application.ex.DadosClienteNotFoundException;
import io.github.cursodsousa.msavaliadorcredito.application.ex.ErroComunicacaoMicroservicesException;
import io.github.cursodsousa.msavaliadorcredito.application.ex.ErroSolicitacaoCartaoException;
import io.github.cursodsousa.msavaliadorcredito.domain.model.*;
import io.github.cursodsousa.msavaliadorcredito.infra.clients.CartoesResourceClient;
import io.github.cursodsousa.msavaliadorcredito.infra.clients.ClienteResourceClient;
import io.github.cursodsousa.msavaliadorcredito.infra.mqueue.SolicitacaoEmissaoCartaoPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AvaliadorCreditoService {
    private final ClienteResourceClient clienteResourceClient;
    private final CartoesResourceClient cartoesResourceClient;
    private final SolicitacaoEmissaoCartaoPublisher solicitacaoEmissaoCartaoPublisher;

    public AvaliadorCreditoService(ClienteResourceClient clienteResourceClient, CartoesResourceClient cartoesResourceClient, SolicitacaoEmissaoCartaoPublisher solicitacaoEmissaoCartaoPublisher) {
        this.clienteResourceClient = clienteResourceClient;
        this.cartoesResourceClient = cartoesResourceClient;
        this.solicitacaoEmissaoCartaoPublisher = solicitacaoEmissaoCartaoPublisher;
    }

    public SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException {
        try {
            return new SituacaoCliente.Builder().dadosCliente(this.clienteResourceClient.dadosCliente(cpf).getBody()).cartaoClienteList(this.cartoesResourceClient.getCartoesByCliente(cpf).getBody()).build();
        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status)
                throw new DadosClienteNotFoundException();
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }

    public RetornoAvaliacaoCliente realizarAvaliacao(String cpf, Long renda) throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException {
        try {
            var listaCartoesAprovados = Objects.requireNonNull(this.cartoesResourceClient.getCartoesRendaAteh(renda).getBody()).stream().map(cartao -> {
                var cartaoAprovado = new CartaoAprovado();
                cartaoAprovado.setCartao(cartao.getNome());
                cartaoAprovado.setBandeira(cartao.getBandeira());
                cartaoAprovado.setLimiteAprovado(BigDecimal.valueOf(Objects.requireNonNull(this.clienteResourceClient.dadosCliente(cpf).getBody()).getIdade()).divide(BigDecimal.valueOf(10), RoundingMode.HALF_UP).multiply(cartao.getLimiteBasico()));
                return cartaoAprovado;
            }).collect(Collectors.toList());
            return new RetornoAvaliacaoCliente(listaCartoesAprovados);
        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status)
                throw new DadosClienteNotFoundException();
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }

    public ProtocoloSolicitacaoCartao solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao) {
        try {
            this.solicitacaoEmissaoCartaoPublisher.solicitarCartao(dadosSolicitacaoEmissaoCartao);
            return new ProtocoloSolicitacaoCartao(UUID.randomUUID().toString());
        } catch (Exception e) {
            throw new ErroSolicitacaoCartaoException(e.getMessage());
        }
    }
}
