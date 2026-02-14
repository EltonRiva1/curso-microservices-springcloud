package io.github.cursodsousa.msavaliadorcredito.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class CartaoAprovado {
    private String cartao, bandeira;
    private BigDecimal limiteAprovado;

    public CartaoAprovado() {
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public BigDecimal getLimiteAprovado() {
        return limiteAprovado;
    }

    public void setLimiteAprovado(BigDecimal limiteAprovado) {
        this.limiteAprovado = limiteAprovado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaoAprovado that = (CartaoAprovado) o;
        return Objects.equals(cartao, that.cartao) && Objects.equals(bandeira, that.bandeira) && Objects.equals(limiteAprovado, that.limiteAprovado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartao, bandeira, limiteAprovado);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CartaoAprovado.class.getSimpleName() + "[", "]")
                .add("cartao='" + cartao + "'")
                .add("bandeira='" + bandeira + "'")
                .add("limiteAprovado=" + limiteAprovado)
                .toString();
    }
}
