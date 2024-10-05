package br.com.compass.msavaliadorcredito.domain.model;

public class DadosAvaliacao {

    private String cpf;
    private Long renda;

    public DadosAvaliacao() {}

    public DadosAvaliacao(String cpf, Long renda) {
        this.cpf = cpf;
        this.renda = renda;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getRenda() {
        return renda;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRenda(Long renda) {
        this.renda = renda;
    }
}
