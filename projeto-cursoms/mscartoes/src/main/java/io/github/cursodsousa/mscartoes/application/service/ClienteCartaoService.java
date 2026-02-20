package io.github.cursodsousa.mscartoes.application.service;

import io.github.cursodsousa.mscartoes.domain.ClienteCartao;
import io.github.cursodsousa.mscartoes.infra.repository.ClienteCartaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteCartaoService {
    private final ClienteCartaoRepository clienteCartaoRepository;

    public ClienteCartaoService(ClienteCartaoRepository clienteCartaoRepository) {
        this.clienteCartaoRepository = clienteCartaoRepository;
    }

    public List<ClienteCartao> listCartoesByCpf(String cpf) {
        return this.clienteCartaoRepository.findByCpf(cpf);
    }
}
