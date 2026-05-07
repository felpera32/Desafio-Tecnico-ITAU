package com.itautest.itautest.Configuration;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;


@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaConfigurations(
        //Impede com que numeros negativos e vazios sejam adicionados
        @NotNull
        @Positive
        Integer segundos) {



}
