package com.makiia.crosscutting.domain.model;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EntyRecgaleriarecmaDto {
    private Integer recUnikeyRegl;
    private String  recNroregRegl;
    private String  apjNroregAphp;
    private String  recObservRegl;
    private String  recGrprecRegr;
    private String  recTiprecRegl;
    private String  recNomrecRegl;
    private Integer recOrdvisRegl;
    private Integer  recDrwpinRegl;
    private String  recRecax1Regl;
    private String  recRecax2Regl;
    private String  recRecax3Regl;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate recFecrecRegl;
    private Double  recHorrecRegl;
    private Long  recRllaveRegl;
    private String  recEstregRegl;

}
