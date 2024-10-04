package br.com.compass.mscartoes.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ClienteCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "id_cartao")
    private Cartao cartao;
    private BigDecimal limite;

    public ClienteCartao() {}

    public ClienteCartao(String cpf, Cartao cartao, BigDecimal limite) {
        this.cpf = cpf;
        this.cartao = cartao;
        this.limite = limite;
    }

    public Long getId() {
        return Id;
    }

    public String getCpf() {
        return cpf;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
}
