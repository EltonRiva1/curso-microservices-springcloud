package io.github.cursodsousa.msclientes.application.representation;

import io.github.cursodsousa.msclientes.domain.Cliente;

import java.util.Objects;
import java.util.StringJoiner;

public class ClienteSaveRequest {
    private String cpf, nome;
    private Integer idade;

    public ClienteSaveRequest() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteSaveRequest that = (ClienteSaveRequest) o;
        return Objects.equals(cpf, that.cpf) && Objects.equals(nome, that.nome) && Objects.equals(idade, that.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, idade);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ClienteSaveRequest.class.getSimpleName() + "[", "]")
                .add("cpf='" + cpf + "'")
                .add("nome='" + nome + "'")
                .add("idade=" + idade)
                .toString();
    }

    public Cliente toModel() {
        return new Cliente(this.cpf, this.nome, this.idade);
    }
}
