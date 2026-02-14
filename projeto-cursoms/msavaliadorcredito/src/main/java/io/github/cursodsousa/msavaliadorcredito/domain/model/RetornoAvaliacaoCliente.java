package io.github.cursodsousa.msavaliadorcredito.domain.model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class RetornoAvaliacaoCliente {
    private List<CartaoAprovado> cartaoAprovados;

    public RetornoAvaliacaoCliente() {
    }

    public RetornoAvaliacaoCliente(List<CartaoAprovado> cartaoAprovados) {
        this.cartaoAprovados = cartaoAprovados;
    }

    public List<CartaoAprovado> getCartaoAprovados() {
        return cartaoAprovados;
    }

    public void setCartaoAprovados(List<CartaoAprovado> cartaoAprovados) {
        this.cartaoAprovados = cartaoAprovados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetornoAvaliacaoCliente that = (RetornoAvaliacaoCliente) o;
        return Objects.equals(cartaoAprovados, that.cartaoAprovados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartaoAprovados);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RetornoAvaliacaoCliente.class.getSimpleName() + "[", "]")
                .add("cartaoAprovados=" + cartaoAprovados)
                .toString();
    }
}
