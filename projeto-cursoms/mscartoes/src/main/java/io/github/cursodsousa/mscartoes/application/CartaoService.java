package io.github.cursodsousa.mscartoes.application;

import io.github.cursodsousa.mscartoes.domain.Cartao;
import io.github.cursodsousa.mscartoes.infra.repository.CartaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {
    private final CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @Transactional
    public void save(Cartao cartao) {
        this.cartaoRepository.save(cartao);
    }
    public List<?> getCartoesRendaMenorIgual(Long renda){
        return this.cartaoRepository.findByRendaLessThanEqual(BigDecimal.valueOf(renda));
    }
}
