package io.github.cursodsousa.msclientes.application;

import io.github.cursodsousa.msclientes.application.representation.ClienteSaveRequest;
import io.github.cursodsousa.msclientes.domain.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clientes")
public class ClientesController {

    private final ClienteService service;

    public ClientesController(ClienteService service) {
        this.service = service;
    }

    //Apenas para testar se entrou na app ou nn
    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteSaveRequest request){
        var cliente = request.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){
        var cliente = service.getByCpf(cpf);
        if(cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }
}
