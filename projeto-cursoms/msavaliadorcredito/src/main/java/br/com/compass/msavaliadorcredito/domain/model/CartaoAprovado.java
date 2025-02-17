package br.com.compass.msavaliadorcredito.domain.model;

import java.math.BigDecimal;

public class CartaoAprovado {

    private String cartao;
    private String bandeira;
    private BigDecimal limiteAprovado;

    public CartaoAprovado() {}

    public CartaoAprovado(String cartao, String bandeira, BigDecimal limiteAprovado) {
        this.cartao = cartao;
        this.bandeira = bandeira;
        this.limiteAprovado = limiteAprovado;
    }

    public String getCartao() {
        return cartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public BigDecimal getLimiteAprovado() {
        return limiteAprovado;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public void setLimiteAprovado(BigDecimal limiteAprovado) {
        this.limiteAprovado = limiteAprovado;
    }
}
