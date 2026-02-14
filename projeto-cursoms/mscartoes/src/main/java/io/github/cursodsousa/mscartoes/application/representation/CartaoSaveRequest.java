package io.github.cursodsousa.mscartoes.application.representation;

import io.github.cursodsousa.mscartoes.domain.BandeiraCartao;
import io.github.cursodsousa.mscartoes.domain.Cartao;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class CartaoSaveRequest {
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda, limite;

    public CartaoSaveRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public void setBandeira(BandeiraCartao bandeira) {
        this.bandeira = bandeira;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaoSaveRequest that = (CartaoSaveRequest) o;
        return Objects.equals(nome, that.nome) && Objects.equals(bandeira, that.bandeira) && Objects.equals(renda, that.renda) && Objects.equals(limite, that.limite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, bandeira, renda, limite);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CartaoSaveRequest.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("bandeira='" + bandeira + "'")
                .add("renda=" + renda)
                .add("limite=" + limite)
                .toString();
    }

    public Cartao toModel() {
        return new Cartao(this.nome, this.bandeira, this.renda, this.limite);
    }
}
