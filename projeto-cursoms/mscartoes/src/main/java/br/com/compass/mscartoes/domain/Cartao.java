package br.com.compass.mscartoes.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity

public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING) //Para salvar Enum como String
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao() {}

    public Cartao(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limiteBasico) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }

    public Long getId() {
        return id;
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

    public BigDecimal getLimiteBasico() {
        return limiteBasico;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setLimiteBasico(BigDecimal limiteBasico) {
        this.limiteBasico = limiteBasico;
    }
}
