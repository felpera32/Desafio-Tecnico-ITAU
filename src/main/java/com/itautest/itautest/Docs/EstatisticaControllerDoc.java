package com.itautest.itautest.Docs;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Estatisticas",
        description = "Endingpoints responsaveis por listar as estastiticas")
public interface EstatisticaControllerDoc {

    @Operation(summary = "Calcula os dados das estatisticas",
            description = "Calcula e retorna a quantidade de transações, soma total dos valores transacionado, Média do valor transacionado, Menor valor transacionado e Maior valor transacionado")
    @ApiResponse(responseCode = "200",
            description = "Retorna todos os valores calculados")

    ResponseEntity<Void> estatistica();
}