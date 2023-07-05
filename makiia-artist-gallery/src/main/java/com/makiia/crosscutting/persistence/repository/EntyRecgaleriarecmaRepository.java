package com.makiia.crosscutting.persistence.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.makiia.crosscutting.persistence.entity.EntyRecgaleriarecma;

public interface EntyRecgaleriarecmaRepository extends JpaRepository<EntyRecgaleriarecma,Integer>
{
        String FILTER_ID_HOMEPAGE_ARTIST_QUERY = "select c from EntyRecgaleriarecma c where UPPER(c.apjNroregAphp) "+
                                                 "like concat('%',upper(?1),'%') and c.recGrprecRegr ='103' "+
                                                 "order by c.recDrwpinRegl, c.recRllaveRegl DESC";
        @Query(value = FILTER_ID_HOMEPAGE_ARTIST_QUERY)
        Page<EntyRecgaleriarecma> findByIdHomePageArtist(String filter, Pageable pageable);
        
        String FILTER_ID_RECUNIKEYREGl_QUERY = "select c from EntyRecgaleriarecma c  where c.recUnikeyRegl  = ?1";
        @Query(value = FILTER_ID_RECUNIKEYREGl_QUERY)
        Page<EntyRecgaleriarecma> findByRecUnikeyRegl(Integer filter, Pageable pageable);

}
