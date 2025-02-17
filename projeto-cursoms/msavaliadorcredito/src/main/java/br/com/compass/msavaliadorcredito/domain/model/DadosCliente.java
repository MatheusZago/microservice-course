package br.com.compass.msavaliadorcredito.domain.model;

public class DadosCliente {

    private Long id;
    private String nome;
    private Integer idade;

    public DadosCliente() {}

    public DadosCliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public DadosCliente(Long id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
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
}
