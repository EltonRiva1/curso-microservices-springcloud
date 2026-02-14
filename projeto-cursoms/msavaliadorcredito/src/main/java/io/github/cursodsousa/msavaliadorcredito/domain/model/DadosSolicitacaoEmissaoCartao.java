package io.github.cursodsousa.msavaliadorcredito.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class DadosSolicitacaoEmissaoCartao {
    private Long idCartao;
    private String cpf, endereco;
    private BigDecimal limiteLiberado;

    public DadosSolicitacaoEmissaoCartao() {
    }

    public Long getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Long idCartao) {
        this.idCartao = idCartao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
        DadosSolicitacaoEmissaoCartao that = (DadosSolicitacaoEmissaoCartao) o;
        return Objects.equals(idCartao, that.idCartao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCartao);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DadosSolicitacaoEmissaoCartao.class.getSimpleName() + "[", "]")
                .add("idCartao=" + idCartao)
                .add("cpf='" + cpf + "'")
                .add("endereco='" + endereco + "'")
                .add("limiteLiberado=" + limiteLiberado)
                .toString();
    }
}
