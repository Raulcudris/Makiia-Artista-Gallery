package com.makiia.crosscutting.persistence.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.makiia.crosscutting.persistence.entity.EntyRecgaleriarecma;

public interface EntyRecgaleriarecmaRepository extends JpaRepository<EntyRecgaleriarecma,Integer>
{
        String FILTER_USUARIO_RECUNIKEYREGl_QUERY = "select c from EntyRecgaleriarecma c  where c.recUnikeyRegl  = ?1";
        @Query(value = FILTER_USUARIO_RECUNIKEYREGl_QUERY)
        Page<EntyRecgaleriarecma> findByRecUnikeyRegl(Integer parameter, Pageable pageable);
        String FILTER_USUARIO_RECNROREGREGL_QUERY = "select c from EntyRecgaleriarecma c where UPPER(c.apjNroregAphp) "+
                                                    "like concat('%',upper(?1),'%') and c.recGrprecRegr ='103' "+
                                                    "order by c.recDrwpinRegl, c.recRllaveRegl DESC";
        @Query(value = FILTER_USUARIO_RECNROREGREGL_QUERY)
        Page<EntyRecgaleriarecma> findByRecNroregRegl(String filter, Pageable pageable);

}
