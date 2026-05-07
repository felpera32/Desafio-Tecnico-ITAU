package com.itautest.itautest.Service;


import com.itautest.itautest.model.TransacaoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Slf4j
@Service
public class TransacaoService {
    public void validarTransacao(TransacaoRequest transacaoRequest){

        if(transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0){
            log.error("Valor invalido! Transações devem ter valor maior ou igual a zero");
            throw new IllegalArgumentException("Erro: Valor invalido! Transações devem ter valor maior ou igual a zero");
        }
        if(transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())){
            log.error("Na data da transação");
            throw new IllegalArgumentException("Erro: Na data da transação");
        }
        if(transacaoRequest.getValor() == null){
            log.error("A entrada de valor é obrigatoria");
            throw new IllegalArgumentException("Erro: A entrada de valores é obrigatoria");
        }
        if(transacaoRequest.getDataHora() == null){
            log.error("A entrada de data é obrigatoria");
            throw new IllegalArgumentException("Erro: A entrada de data é obrigatoria");

        }
    }
}
