package com.makiia.crosscutting.persistence.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recgaleriarecma")
public class EntyRecgaleriarecma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rec_unikey_regl")
    private Integer  recUnikeyRegl;

    @Basic(optional = false)
    @Column(name = "rec_nroreg_regl")
    private String recNroregRegl;

    @Basic(optional = false)
    @Column(name = "apj_nroreg_aphp")
    private String apjNroregAphp;

    @Basic(optional = false)
    @Column(name = "rec_observ_regl")
    private String recObservRegl;

    @Basic(optional = false)
    @Column(name = "rec_grprec_regr")
    private String recGrprecRegr;

    @Basic(optional = false)
    @Column(name = "rec_tiprec_regl")
    private String  recTiprecRegl;

    @Basic(optional = false)
    @Column(name = "rec_nomrec_regl")
    private String  recNomrecRegl;
    @Basic(optional = false)
    @Column(name = "rec_ordvis_regl")
    private Integer  recOrdvisRegl;

    @Basic(optional = false)
    @Column(name = "rec_drwpin_Regl")
    private Integer  recDrwpinRegl;

    @Basic(optional = false)
    @Column(name = "rec_recax1_regl")
    private String  recRecax1Regl;

    @Basic(optional = false)
    @Column(name = "rec_recax2_regl")
    private String  recRecax2Regl;

    @Basic(optional = false)
    @Column(name = "rec_recax3_regl")
    private String  recRecax3Regl;

    @Basic(optional = false)
    @Column(name = "rec_fecrec_regl")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate recFecrecRegl;

    @Basic(optional = false)
    @Column(name = "rec_horrec_regl")
    private Double  recHorrecRegl;

    @Basic(optional = false)
    @Column(name = "rec_rllave_regl")
    private Long recRllaveRegl;

    @Basic(optional = false)
    @Column(name = "rec_estreg_regl")
    private String  recEstregRegl;

}
