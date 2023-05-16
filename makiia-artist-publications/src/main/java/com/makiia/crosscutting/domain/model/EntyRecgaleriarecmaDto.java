package com.makiia.crosscutting.domain.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.sql.Date;

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
    private String  recRecax1Regl;
    private String  recRecax2Regl;
    private String  recRecax3Regl;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date    recFecrecRegl;
    private Double  recHorrecRegl;
    private Double  recRllaveRegl;
    private String  RecEstregRegl;

}
