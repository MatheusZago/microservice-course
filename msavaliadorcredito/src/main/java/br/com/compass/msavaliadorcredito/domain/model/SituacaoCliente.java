package br.com.compass.msavaliadorcredito.domain.model;

import java.util.List;

public class SituacaoCliente {

    private DadosCliente cliente;
    private List<CartaoCliente> cartoes;

    // Construtor privado usado pelo builder
    private SituacaoCliente(SituacaoCliente.Builder builder) {
        this.cliente = builder.cliente;
        this.cartoes = builder.cartoes;
    }

    // Getters
    public DadosCliente getCliente() {
        return cliente;
    }

    public List<CartaoCliente> getCartoes() {
        return cartoes;
    }

    // Setters
    public void setCliente(DadosCliente cliente) {
        this.cliente = cliente;
    }

    public void setCartoes(List<CartaoCliente> cartoes) {
        this.cartoes = cartoes;
    }

    // Método estático para iniciar o builder
    public static Builder builder() {
        return new Builder();
    }

    // Classe estática Builder
    public static class Builder {
        private DadosCliente cliente;
        private List<CartaoCliente> cartoes;

        // Método para definir o cliente
        public Builder cliente(DadosCliente cliente) {
            this.cliente = cliente;
            return this; // Retorna o próprio Builder para encadeamento
        }

        // Método para definir os cartões
        public Builder cartoes(List<CartaoCliente> cartoes) {
            this.cartoes = cartoes;
            return this; // Retorna o próprio Builder para encadeamento
        }

        // Método final para construir o objeto SituacaoCliente
        public SituacaoCliente build() {
            return new SituacaoCliente(this); // Retorna a instância final de SituacaoCliente
        }
    }
}
