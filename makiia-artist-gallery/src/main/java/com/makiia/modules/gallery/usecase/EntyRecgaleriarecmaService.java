package com.makiia.modules.gallery.usecase;
import com.makiia.crosscutting.domain.model.EntyDeleteDto;
import com.makiia.crosscutting.domain.model.EntyGaleryUtiliDto;
import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaDto;
import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaResponse;
import com.makiia.crosscutting.exceptions.ExceptionBuilder;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.messages.SearchMessages;
import com.makiia.modules.bus.services.UseCase;
import com.makiia.modules.bus.services.UsecaseServices;
import com.makiia.modules.gallery.dataproviders.jpa.JpaEntyRecgaleriarecmaDataProviders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import javax.annotation.PostConstruct;
import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@UseCase
public class EntyRecgaleriarecmaService extends UsecaseServices<EntyRecgaleriarecmaDto, JpaEntyRecgaleriarecmaDataProviders>
{
    @Autowired
    private JpaEntyRecgaleriarecmaDataProviders jpaDataProviders;
    @PostConstruct
    public void init(){
        this.ijpaDataProvider = jpaDataProviders;
    }

    public LocalDate localDateNow;
    private Double localTimeNow;
    private String dateNowWhitTime;
    private String timeNowHourMin;
    private Long ordeView;

    public EntyRecgaleriarecmaResponse saveBefore(EntyRecgaleriarecmaResponse dto) throws EBusinessException {
        try{
            List<EntyRecgaleriarecmaDto>  dtoAux = this.ijpaDataProvider.save(dto.getRspData());
            localDateNow = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            dateNowWhitTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
            timeNowHourMin = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH.mm"));
            localTimeNow = Double.valueOf(timeNowHourMin);
            ordeView = Long.valueOf(dateNowWhitTime);
            for (EntyRecgaleriarecmaDto dtox : dtoAux){
                dtox.setRecFecrecRegl(localDateNow);
                dtox.setRecHorrecRegl(localTimeNow);
                dtox.setRecOrdvisRegl(1);
                dtox.setRecDrwpinRegl(1);
                dtox.setRecRllaveRegl(ordeView);
            }
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

    public String changestatusAll(List<EntyGaleryUtiliDto> dto) throws EBusinessException {
        try {
            dateNowWhitTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
            ordeView = Long.valueOf(dateNowWhitTime);
            EntyRecgaleriarecmaDto rspto = new EntyRecgaleriarecmaDto();

            for (EntyGaleryUtiliDto dtox : dto) {
                rspto = this.ijpaDataProvider.get(dtox.getRecPKey());
                if(dtox.getRecDrawPing() == 1)
                {
                    rspto.setRecRllaveRegl(ordeView);
                }          
                rspto.setRecDrwpinRegl(dtox.getRecDrawPing());           
                this.ijpaDataProvider.update(dtox.getRecPKey(),rspto);
            }
            return "OK";

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
