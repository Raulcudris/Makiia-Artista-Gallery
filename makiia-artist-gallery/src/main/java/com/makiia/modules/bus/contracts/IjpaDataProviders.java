package com.makiia.modules.bus.contracts;
import java.util.List;

import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaResponse;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;

public interface  IjpaDataProviders<T> {

    //List<T> getAll() throws EBusinessException;
    EntyRecgaleriarecmaResponse getAll() throws  EBusinessException;
    EntyRecgaleriarecmaResponse getAll (int currentPage , int pageSize, int parameter, String filter) throws EBusinessException;
    T get(Integer id) throws EBusinessException;
    T save(T dto) throws EBusinessException;
    List<T> save(List<T> dto) throws EBusinessException;
    T update(Integer id, T dto) throws EBusinessException;
    void delete(Integer id) throws EBusinessException;
}
