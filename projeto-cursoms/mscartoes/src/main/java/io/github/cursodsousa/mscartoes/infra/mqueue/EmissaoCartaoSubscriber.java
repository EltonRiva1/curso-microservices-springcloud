package io.github.cursodsousa.mscartoes.infra.mqueue;

import io.github.cursodsousa.mscartoes.domain.ClienteCartao;
import io.github.cursodsousa.mscartoes.domain.DadosSolicitacaoEmissaoCartao;
import io.github.cursodsousa.mscartoes.infra.repository.CartaoRepository;
import io.github.cursodsousa.mscartoes.infra.repository.ClienteCartaoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class EmissaoCartaoSubscriber {
    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;

    public EmissaoCartaoSubscriber(CartaoRepository cartaoRepository, ClienteCartaoRepository clienteCartaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.clienteCartaoRepository = clienteCartaoRepository;
    }

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload) {
        var dadosSolicitacaoEmissaoCartao = new ObjectMapper().readValue(payload, DadosSolicitacaoEmissaoCartao.class);
        var clienteCartao = new ClienteCartao();
        clienteCartao.setCartao(this.cartaoRepository.findById(dadosSolicitacaoEmissaoCartao.getIdCartao()).orElseThrow());
        clienteCartao.setCpf(dadosSolicitacaoEmissaoCartao.getCpf());
        clienteCartao.setLimite(dadosSolicitacaoEmissaoCartao.getLimiteLiberado());
        this.clienteCartaoRepository.save(clienteCartao);
    }
}
