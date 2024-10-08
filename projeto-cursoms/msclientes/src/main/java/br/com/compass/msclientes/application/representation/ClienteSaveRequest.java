package br.com.compass.msclientes.application.representation;

import br.com.compass.msclientes.domain.Cliente;

import java.util.Objects;

public class ClienteSaveRequest {

    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel(){
        return new Cliente(cpf, nome, idade);
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
