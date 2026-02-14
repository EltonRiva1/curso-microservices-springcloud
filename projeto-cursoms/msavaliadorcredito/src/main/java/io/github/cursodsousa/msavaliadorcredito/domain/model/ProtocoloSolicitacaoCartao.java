package io.github.cursodsousa.msavaliadorcredito.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class ProtocoloSolicitacaoCartao {
    private String protocolo;

    public ProtocoloSolicitacaoCartao() {
    }

    public ProtocoloSolicitacaoCartao(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtocoloSolicitacaoCartao that = (ProtocoloSolicitacaoCartao) o;
        return Objects.equals(protocolo, that.protocolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(protocolo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProtocoloSolicitacaoCartao.class.getSimpleName() + "[", "]")
                .add("protocolo='" + protocolo + "'")
                .toString();
    }
}
