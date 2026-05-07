package com.itautest.itautest.Docs;

import com.itautest.itautest.model.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;



@Tag(name="Transações",
        description = "Endingpoints responsaveis por criar e adicionar as transações em lista")


public interface TransacaoControllerDoc {
    @Operation(summary = "Cria transação",
            description = "Recebe uma transação valida e adiciona em uma lista")

    @ApiResponse(responseCode = "201",
            description = "Transação criada com sucesso")

    @ApiResponse(responseCode = "422",
            description = "Erro de validação capturado")

    @ApiResponse(responseCode = "400",
            description = "Erro inesperado no servidor")
    ResponseEntity<Void> adicionar(@RequestBody TransacaoRequest transacaoRequest);


    @Operation(summary = "Deleta os dados",
            description = "Deleta os dados capturados")
    public ResponseEntity<Void> deletar();
}
