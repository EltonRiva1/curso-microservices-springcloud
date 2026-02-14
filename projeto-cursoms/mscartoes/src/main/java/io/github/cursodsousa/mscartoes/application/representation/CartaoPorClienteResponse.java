package io.github.cursodsousa.mscartoes.application.representation;

import io.github.cursodsousa.mscartoes.domain.ClienteCartao;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class CartaoPorClienteResponse {
    private String nome, bandeira;
    private BigDecimal limiteLiberado;

    public CartaoPorClienteResponse() {
    }

    public CartaoPorClienteResponse(String nome, String bandeira, BigDecimal limiteLiberado) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.limiteLiberado = limiteLiberado;
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
        CartaoPorClienteResponse that = (CartaoPorClienteResponse) o;
        return Objects.equals(nome, that.nome) && Objects.equals(bandeira, that.bandeira) && Objects.equals(limiteLiberado, that.limiteLiberado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, bandeira, limiteLiberado);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CartaoPorClienteResponse.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("bandeira='" + bandeira + "'")
                .add("limiteLiberado=" + limiteLiberado)
                .toString();
    }

    public static CartaoPorClienteResponse fromModel(ClienteCartao clienteCartao) {
        return new CartaoPorClienteResponse(clienteCartao.getCartao().getNome(), clienteCartao.getCartao().getBandeira().toString(), clienteCartao.getLimite());
    }
}
