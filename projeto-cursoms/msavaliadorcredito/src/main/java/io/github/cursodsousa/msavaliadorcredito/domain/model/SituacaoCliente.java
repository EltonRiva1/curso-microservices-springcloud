package io.github.cursodsousa.msavaliadorcredito.domain.model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class SituacaoCliente {
    private DadosCliente dadosCliente;
    private List<CartaoCliente> cartaoClienteList;

    public SituacaoCliente() {
    }

    private SituacaoCliente(Builder builder) {
        this.dadosCliente = builder.dadosCliente;
        this.cartaoClienteList = builder.cartaoClienteList;
    }

    public DadosCliente getDadosCliente() {
        return dadosCliente;
    }

    public void setDadosCliente(DadosCliente dadosCliente) {
        this.dadosCliente = dadosCliente;
    }

    public List<CartaoCliente> getCartaoClienteList() {
        return cartaoClienteList;
    }

    public void setCartaoClienteList(List<CartaoCliente> cartaoClienteList) {
        this.cartaoClienteList = cartaoClienteList;
    }

    public static class Builder {

        private DadosCliente dadosCliente;
        private List<CartaoCliente> cartaoClienteList;

        public Builder() {
        }

        public Builder dadosCliente(DadosCliente dadosCliente) {
            this.dadosCliente = dadosCliente;
            return this;
        }

        public Builder cartaoClienteList(List<CartaoCliente> cartaoClienteList) {
            this.cartaoClienteList = cartaoClienteList;
            return this;
        }

        public SituacaoCliente build() {
            return new SituacaoCliente(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SituacaoCliente that = (SituacaoCliente) o;
        return Objects.equals(dadosCliente, that.dadosCliente)
                && Objects.equals(cartaoClienteList, that.cartaoClienteList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dadosCliente, cartaoClienteList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SituacaoCliente.class.getSimpleName() + "[", "]")
                .add("dadosCliente=" + dadosCliente)
                .add("cartaoClienteList=" + cartaoClienteList)
                .toString();
    }
}
