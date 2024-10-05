package br.com.compass.msavaliadorcredito.application;

import br.com.compass.msavaliadorcredito.domain.model.CartaoCliente;
import br.com.compass.msavaliadorcredito.domain.model.DadosCliente;
import br.com.compass.msavaliadorcredito.domain.model.SituacaoCliente;
import br.com.compass.msavaliadorcredito.infra.clients.CartoesResourceClient;
import br.com.compass.msavaliadorcredito.infra.clients.ClienteResourceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;
    private final CartoesResourceClient cartoesClient;

    public AvaliadorCreditoService(ClienteResourceClient clientesClient, CartoesResourceClient cartoesClient) {
        this.clientesClient = clientesClient;
        this.cartoesClient = cartoesClient;
    }

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        //ObterDadosClientes - MSCLIENTES
        ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
        //ObterDadosCartoes - MSCARTOES
        ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesClient.getCartoesPorCpf(cpf);

        return SituacaoCliente.builder()
                .cliente(dadosClienteResponse.getBody())
                .cartoes(cartoesResponse.getBody())
                .build();
    }

}
