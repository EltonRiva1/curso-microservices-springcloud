package io.github.cursodsousa.msavaliadorcredito.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class CartaoCliente {
    private String nome, bandeira;
    private BigDecimal limiteLiberado;

    public CartaoCliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public BigDecimal getLimiteLiberado() {
        return limiteLiberado;
    }

    public void setLimiteLiberado(BigDecimal limiteLiberado) {
        this.limiteLiberado = limiteLiberado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaoCliente that = (CartaoCliente) o;
        return Objects.equals(nome, that.nome) && Objects.equals(bandeira, that.bandeira) && Objects.equals(limiteLiberado, that.limiteLiberado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, bandeira, limiteLiberado);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CartaoCliente.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("bandeira='" + bandeira + "'")
                .add("limiteLiberado=" + limiteLiberado)
                .toString();
    }
}
