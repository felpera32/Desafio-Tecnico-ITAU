package com.itautest.itautest.Repository;

import com.itautest.itautest.model.EstatisticaDTO;
import com.itautest.itautest.model.Transacao;
import com.itautest.itautest.model.TransacaoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    public List<TransacaoRequest> getListaDeTransacoes() {
        return listaDeTransacoes;
    }

    public void salvarDados(TransacaoRequest transacaoRequest){
        listaDeTransacoes.add(transacaoRequest);
    }
    public void limparDados(TransacaoRequest transacaoRequest){
    }
    public void deletarDados(){
        log.info("Lista de transações deletada");
        listaDeTransacoes.clear();
    }






    public EstatisticaDTO estatistica(OffsetDateTime horaInicial){

        if(listaDeTransacoes.isEmpty()){
            log.info("Nenhum valor foi enviado");
            return new EstatisticaDTO(new Long(0), 0.0, 0.0, 0.0, 0.0);
        }
        //summaryStatistics = Faz operações dentro da lista filtrada
        log.info("Fazendo todos os calculos dos ultimos 60 segundos");
        final var summary = listaDeTransacoes.stream()
                .filter(t ->
                        t.getDataHora().isAfter(horaInicial) ||  t.getDataHora().isEqual(horaInicial)
                        ).mapToDouble(t -> t.getValor().doubleValue()).summaryStatistics();

        return new EstatisticaDTO(summary.getCount(), summary.getSum(), summary.getAverage(), summary.getMin(), summary.getMax());
    }
}
