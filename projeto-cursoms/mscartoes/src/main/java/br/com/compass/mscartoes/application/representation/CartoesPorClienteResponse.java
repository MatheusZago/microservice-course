package br.com.compass.mscartoes.application.representation;

import br.com.compass.mscartoes.domain.ClienteCartao;

import java.math.BigDecimal;

public class CartoesPorClienteResponse {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public CartoesPorClienteResponse() {}

    public CartoesPorClienteResponse(String nome, String bandeira, BigDecimal limiteLiberado) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.limiteLiberado = limiteLiberado;
    }

    public static CartoesPorClienteResponse fromModel(ClienteCartao model) {
        return new CartoesPorClienteResponse(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimite()
        );
    }

    public String getNome() {
        return nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public BigDecimal getLimiteLiberado() {
        return limiteLiberado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public void setLimiteLiberado(BigDecimal limiteLiberado) {
        this.limiteLiberado = limiteLiberado;
    }
}
