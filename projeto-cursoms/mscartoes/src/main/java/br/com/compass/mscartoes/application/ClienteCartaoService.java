package br.com.compass.mscartoes.application;

import br.com.compass.mscartoes.domain.ClienteCartao;
import br.com.compass.mscartoes.infra.repository.ClienteCartaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public ClienteCartaoService(ClienteCartaoRepository repository) {
        this.repository = repository;
    }

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
