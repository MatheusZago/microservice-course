package br.com.compass.mscartoes.infra.mqueue;

import br.com.compass.mscartoes.domain.Cartao;
import br.com.compass.mscartoes.domain.ClienteCartao;
import br.com.compass.mscartoes.domain.DadosSolicitacaoEmissaoCartao;
import br.com.compass.mscartoes.infra.repository.CartaoRepository;
import br.com.compass.mscartoes.infra.repository.ClienteCartaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;

    public EmissaoCartaoSubscriber(CartaoRepository cartaoRepository, ClienteCartaoRepository clienteCartaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.clienteCartaoRepository = clienteCartaoRepository;
    }


    //Está escutando essa fila, para qnd ela for chamadaa
    //Esse método é o "interessado" de qnd a lista for lançada
    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload){
        try{
            var mapper = new ObjectMapper();
            //Transforma payload em dados de soliciticao
            DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
            Cartao cartao = cartaoRepository.findById(dados.getIdCartao()).orElseThrow();
            ClienteCartao clienteCartao = new ClienteCartao();
            clienteCartao.setCartao(cartao);
            clienteCartao.setCpf(dados.getCpf());
            clienteCartao.setLimite(dados.getLimiteLiberado());

            clienteCartaoRepository.save(clienteCartao);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

}
