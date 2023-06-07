package com.makiia.crosscutting.domain.model;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntyRecgaleriarecmaResponse {
    private  String rspValue ;
    private  String rspMessage ;
    private  String rspParentKey ;
    private  String rspAppKey ;
    private  PaginationResponse rspPagination = new PaginationResponse();
    private  List<EntyRecgaleriarecmaDto> rspData;

}

