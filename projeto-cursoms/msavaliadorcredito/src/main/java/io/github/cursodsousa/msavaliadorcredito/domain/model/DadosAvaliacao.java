package io.github.cursodsousa.msavaliadorcredito.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class DadosAvaliacao {
    private String cpf;
    private Long renda;

    public DadosAvaliacao() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getRenda() {
        return renda;
    }

    public void setRenda(Long renda) {
        this.renda = renda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DadosAvaliacao that = (DadosAvaliacao) o;
        return Objects.equals(cpf, that.cpf) && Objects.equals(renda, that.renda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, renda);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DadosAvaliacao.class.getSimpleName() + "[", "]")
                .add("cpf='" + cpf + "'")
                .add("renda=" + renda)
                .toString();
    }
}
