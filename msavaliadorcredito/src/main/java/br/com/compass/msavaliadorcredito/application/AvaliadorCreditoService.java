package br.com.compass.msavaliadorcredito.application;

import br.com.compass.msavaliadorcredito.domain.model.DadosCliente;
import br.com.compass.msavaliadorcredito.domain.model.SituacaoCliente;
import br.com.compass.msavaliadorcredito.infra.clients.ClienteResourceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;

    public AvaliadorCreditoService(ClienteResourceClient clientesClient) {
        this.clientesClient = clientesClient;
    }

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        //ObterDadosClientes - MSCLIENTES
        ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
        return SituacaoCliente.builder()
                .cliente(dadosClienteResponse.getBody())
                //Adicionar cartoes dps
                .build();
        //ObterDadosCartoes - MSCARTOES
    }

}
