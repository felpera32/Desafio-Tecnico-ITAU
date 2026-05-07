package com.itautest.itautest.Controllers;

import com.itautest.itautest.Configuration.EstatisticaConfigurations;
import com.itautest.itautest.Docs.EstatisticaControllerDoc;
import com.itautest.itautest.Repository.TransacaoRepository;
import com.itautest.itautest.model.Transacao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")

public class EstatisticaController implements EstatisticaControllerDoc{
    private final EstatisticaConfigurations configurations;
    private final TransacaoRepository transacaoRepository;

    public EstatisticaController(EstatisticaConfigurations configurations, TransacaoRepository transacaoRepository) {
        this.configurations = configurations;
        this.transacaoRepository = transacaoRepository;
    }


    //Log de requisição via Lombok
    @GetMapping
    public ResponseEntity estatistica(){
        log.info("Calculando estatisticas de Transações dos ultimos " + configurations.segundos() + " segundos");
        final var horaInicial = OffsetDateTime.now().minusSeconds(configurations.segundos());
        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }
}
