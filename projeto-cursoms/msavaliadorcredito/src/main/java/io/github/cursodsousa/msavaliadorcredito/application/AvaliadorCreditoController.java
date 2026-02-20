package io.github.cursodsousa.msavaliadorcredito.application;

import io.github.cursodsousa.msavaliadorcredito.application.ex.DadosClienteNotFoundException;
import io.github.cursodsousa.msavaliadorcredito.application.ex.ErroComunicacaoMicroservicesException;
import io.github.cursodsousa.msavaliadorcredito.application.ex.ErroSolicitacaoCartaoException;
import io.github.cursodsousa.msavaliadorcredito.application.service.AvaliadorCreditoService;
import io.github.cursodsousa.msavaliadorcredito.domain.model.DadosAvaliacao;
import io.github.cursodsousa.msavaliadorcredito.domain.model.DadosSolicitacaoEmissaoCartao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("avaliacoes-credito")
public class AvaliadorCreditoController {
    private final AvaliadorCreditoService avaliadorCreditoService;

    public AvaliadorCreditoController(AvaliadorCreditoService avaliadorCreditoService) {
        this.avaliadorCreditoService = avaliadorCreditoService;
    }

    @GetMapping
    public String status() {
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity<?> consultarSituacaoCliente(@RequestParam("cpf") String cpf) {
        try {
            return ResponseEntity.ok(this.avaliadorCreditoService.obterSituacaoCliente(cpf));
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.valueOf(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> realizarAvaliacao(@RequestBody DadosAvaliacao dadosAvaliacao) {
        try {
            return ResponseEntity.ok(this.avaliadorCreditoService.realizarAvaliacao(dadosAvaliacao.getCpf(), dadosAvaliacao.getRenda()));
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.valueOf(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping("solicitacoes-cartao")
    public ResponseEntity<?> solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao) {
        try {
            return ResponseEntity.ok(this.avaliadorCreditoService.solicitarEmissaoCartao(dadosSolicitacaoEmissaoCartao));
        } catch (ErroSolicitacaoCartaoException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
