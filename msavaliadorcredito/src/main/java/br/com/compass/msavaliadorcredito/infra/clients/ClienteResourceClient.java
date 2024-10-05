package br.com.compass.msavaliadorcredito.infra.clients;

import br.com.compass.msavaliadorcredito.domain.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Vai fazer requisições para os controllers de clientes
@FeignClient(value = "msclientes", path = "/clientes") //É um cliente http para comunicação entre microserviços
public interface ClienteResourceClient {

    //Ele vai usar esse metodo lá do mscliente
    @GetMapping(params = "cpf")
    public ResponseEntity<DadosCliente> dadosCliente(@RequestParam("cpf") String cpf);

}
