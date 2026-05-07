package com.itautest.itautest.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoRequest {
    @NotNull(message="O valor da transação é obrigatorio")
    @Positive(message = "O valor da transação deve ser igual ou maior a 0")
    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
