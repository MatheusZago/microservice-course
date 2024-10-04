package br.com.compass.mscartoes.application.representation;

import br.com.compass.mscartoes.domain.BandeiraCartao;
import br.com.compass.mscartoes.domain.Cartao;

import java.math.BigDecimal;

public class CartaoSaveRequest {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public CartaoSaveRequest() {}

    public CartaoSaveRequest(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limite) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limite = limite;
    }

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }

    public String getNome() {
        return nome;
    }

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBandeira(BandeiraCartao bandeira) {
        this.bandeira = bandeira;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
}
