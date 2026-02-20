package io.github.cursodsousa.msclientes.application;

import io.github.cursodsousa.msclientes.application.representation.ClienteSaveRequest;
import io.github.cursodsousa.msclientes.application.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("clientes")
public class ClientesResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientesResource.class);
    private final ClienteService clienteService;

    public ClientesResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String status() {
        LOGGER.info("Obtendo o status do microservice de clientes");
        return "ok";
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteSaveRequest clienteSaveRequest) {
        var cliente = clienteSaveRequest.toModel();
        this.clienteService.save(cliente);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(cliente.getCpf()).toUri()).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<?> dadosCliente(@RequestParam("cpf") String cpf) {
        var cliente = this.clienteService.getByCpf(cpf);
        if (cliente.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente);
    }
}
