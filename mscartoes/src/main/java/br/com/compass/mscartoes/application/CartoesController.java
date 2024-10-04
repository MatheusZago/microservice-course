package br.com.compass.mscartoes.application;

import br.com.compass.mscartoes.application.representation.CartaoSaveRequest;
import br.com.compass.mscartoes.domain.Cartao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartoes")
public class CartoesController {

    private final CartaoService service;

    public CartoesController(CartaoService service) {
        this.service = service;
    }


    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        service.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda) {
        List<Cartao> lista = service.getCartoesRendarMenorIgual(renda);
        return ResponseEntity.ok(lista);
    }
}
