package io.github.cursodsousa.msclientes.application;

import io.github.cursodsousa.msclientes.domain.Cliente;
import io.github.cursodsousa.msclientes.infra.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {


    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

}
