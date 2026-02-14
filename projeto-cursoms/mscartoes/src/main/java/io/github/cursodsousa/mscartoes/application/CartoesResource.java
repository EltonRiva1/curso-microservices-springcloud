package io.github.cursodsousa.mscartoes.application;

import io.github.cursodsousa.mscartoes.application.representation.CartaoPorClienteResponse;
import io.github.cursodsousa.mscartoes.application.representation.CartaoSaveRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartoes")
public class CartoesResource {
    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    public CartoesResource(CartaoService cartaoService, ClienteCartaoService clienteCartaoService) {
        this.cartaoService = cartaoService;
        this.clienteCartaoService = clienteCartaoService;
    }

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody CartaoSaveRequest cartaoSaveRequest) {
        this.cartaoService.save(cartaoSaveRequest.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<?>> getCartoesRendaAteh(@RequestParam("renda") Long renda) {
        return ResponseEntity.ok(this.cartaoService.getCartoesRendaMenorIgual(renda));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<?>> getCartoesByCliente(@RequestParam("cpf") String cpf) {
        return ResponseEntity.ok(this.clienteCartaoService.listCartoesByCpf(cpf).stream().map(CartaoPorClienteResponse::fromModel).toList());
    }
}
