package com.itautest.itautest.Controllers;

import com.itautest.itautest.Docs.EstatisticaControllerDoc;
import com.itautest.itautest.Docs.TransacaoControllerDoc;
import com.itautest.itautest.Repository.TransacaoRepository;
import com.itautest.itautest.Service.TransacaoService;
import com.itautest.itautest.model.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")

public class TransacaoController implements TransacaoControllerDoc {
    private final TransacaoService service;
    private TransacaoRepository repository;

    public TransacaoController(TransacaoService service, TransacaoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping


    public ResponseEntity adicionar(@RequestBody TransacaoRequest transacaoRequest){
        try{
            log.info("Validando e salvando dados das transações");
            service.validarTransacao(transacaoRequest);
            repository.salvarDados(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception){
            log.error("Error em uma ou mais validações, tente novamente");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }catch (Exception e){
            log.error("Erro no servidor, tente novamente");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


    @DeleteMapping()
    public ResponseEntity deletar(){
        repository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
