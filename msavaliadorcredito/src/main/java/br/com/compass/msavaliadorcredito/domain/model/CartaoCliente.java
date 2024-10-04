package br.com.compass.msavaliadorcredito.domain.model;

import java.math.BigDecimal;

public class CartaoCliente {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public CartaoCliente() {}

    public CartaoCliente(String nome, String bandeira, BigDecimal limiteLiberado) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.limiteLiberado = limiteLiberado;
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
