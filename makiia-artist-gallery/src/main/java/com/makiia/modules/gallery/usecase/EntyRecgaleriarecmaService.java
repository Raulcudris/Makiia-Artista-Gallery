package com.makiia.modules.gallery.usecase;
import com.makiia.crosscutting.domain.model.EntyDeleteDto;
import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaDto;
import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaResponse;
import com.makiia.crosscutting.exceptions.ExceptionBuilder;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.messages.SearchMessages;
import com.makiia.modules.bus.services.UseCase;
import com.makiia.modules.bus.services.UsecaseServices;
import com.makiia.modules.gallery.dataproviders.jpa.JpaEntyRecgaleriarecmaDataProviders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import javax.annotation.PostConstruct;
import javax.persistence.PersistenceException;
import java.util.List;
@Log4j2
@UseCase
public class EntyRecgaleriarecmaService extends UsecaseServices<EntyRecgaleriarecmaDto, JpaEntyRecgaleriarecmaDataProviders>
{
    @Autowired
    private JpaEntyRecgaleriarecmaDataProviders jpaDataProviders;
    @PostConstruct
    public void init(){
        this.ijpaDataProvider = jpaDataProviders;
    }

    public EntyRecgaleriarecmaResponse saveBefore(EntyRecgaleriarecmaResponse dto) throws EBusinessException {
        try{
            List<EntyRecgaleriarecmaDto>  dtoAux = this.ijpaDataProvider.save(dto.getRspData());
            dtoAux = this.ijpaDataProvider.save(dtoAux);
            dto.setRspData(dtoAux);
            return dto;
        }catch (PersistenceException | DataAccessException e){
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    public EntyRecgaleriarecmaResponse updateAll(EntyRecgaleriarecmaResponse dto) throws EBusinessException {
        try {
            List<EntyRecgaleriarecmaDto> dtoAux = dto.getRspData();

            for (EntyRecgaleriarecmaDto dtox : dtoAux){
                dtox = this.ijpaDataProvider.update(dtox.getRecUnikeyRegl(),dtox);
            }
            dto.setRspData(dtoAux);
            return dto;

        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.UPDATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.UPDATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    public String deleteAll(List<EntyDeleteDto> dto) throws EBusinessException {
        try {

            for (EntyDeleteDto dtox : dto) {
                this.ijpaDataProvider.delete(dtox.getRecPKey());
            }
            return "OK";

        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.DELETE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.DELETE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }


}
