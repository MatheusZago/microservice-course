package br.com.compass.msavaliadorcredito.application;

import br.com.compass.msavaliadorcredito.application.ex.DadosClienteNotFoundException;
import br.com.compass.msavaliadorcredito.application.ex.ErroComunicacaoMicroserviceException;
import br.com.compass.msavaliadorcredito.domain.model.CartaoCliente;
import br.com.compass.msavaliadorcredito.domain.model.DadosCliente;
import br.com.compass.msavaliadorcredito.domain.model.SituacaoCliente;
import br.com.compass.msavaliadorcredito.infra.clients.CartoesResourceClient;
import br.com.compass.msavaliadorcredito.infra.clients.ClienteResourceClient;
import feign.FeignException;
import org.springframework.http.HttpStatus;
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

    public SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException, ErroComunicacaoMicroserviceException {

        try{
            ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
            ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesClient.getCartoesPorCpf(cpf);

            return SituacaoCliente.builder()
                    .cliente(dadosClienteResponse.getBody())
                    .cartoes(cartoesResponse.getBody())
                    .build();
        }catch (FeignException.FeignClientException e){
            int status = e.status();
            if(HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException();
            }
            throw new ErroComunicacaoMicroserviceException(e.getMessage(), status);
        }

    }

}
