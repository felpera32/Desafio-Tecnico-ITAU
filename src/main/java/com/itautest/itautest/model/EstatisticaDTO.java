package com.itautest.itautest.model;


import lombok.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticaDTO {
    private Long count;
    private double sum;
    private double avg;
    private double min;
    private double max;


}
