package com.makiia.modules.gallery.dataproviders.jpa;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaDto;
import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaResponse;
import com.makiia.crosscutting.domain.model.PaginationResponse;
import com.makiia.crosscutting.exceptions.DataProvider;
import com.makiia.crosscutting.exceptions.ExceptionBuilder;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.messages.SearchMessages;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntyRecgaleriarecma;
import com.makiia.crosscutting.persistence.repository.EntyRecgaleriarecmaRepository;
import com.makiia.modules.gallery.dataproviders.IjpaEntyRecgaleriarecmaDataProviders;

@DataProvider
public class JpaEntyRecgaleriarecmaDataProviders implements IjpaEntyRecgaleriarecmaDataProviders {

    @Autowired
    private EntyRecgaleriarecmaRepository repository;
    @Autowired
    @Qualifier("entyRecgaleriarecmaSaveResponseTranslate")
    private Translator<EntyRecgaleriarecma, EntyRecgaleriarecmaDto>saveResponseTranslate;
    @Autowired
    @Qualifier("entyRecgaleriarecmaDtoToEntityTranslate")
    private Translator<EntyRecgaleriarecmaDto, EntyRecgaleriarecma>dtoToEntityTranslate;

    @Override
    public EntyRecgaleriarecmaResponse getAll() throws EBusinessException {
        try {
            List<EntyRecgaleriarecma> responses = (List<EntyRecgaleriarecma>) repository.findAll();
            int currentPage=0;
            int totalPageSize=responses.size();
            Pageable pageable = PageRequest.of(currentPage, totalPageSize);
            //Pageable paginacion
            Page<EntyRecgaleriarecma> ResponsePage = null;
            ResponsePage = repository.findAll(pageable);

            List<EntyRecgaleriarecma> ListPage = ResponsePage.getContent();
            List<EntyRecgaleriarecmaDto> content  = ListPage.stream().map(p ->mapToDto(p)).collect(Collectors.toList());

            EntyRecgaleriarecmaResponse response = new EntyRecgaleriarecmaResponse();
            response.setRspMessage(response.getRspMessage());
            response.setRspValue(response.getRspValue());

            currentPage = currentPage + 1;
            String nextPageUrl = "LocalHost";
            String previousPageUrl = "LocalHost";
            response.setRspPagination(headResponse(currentPage, content.size(), ResponsePage.getTotalElements(), ResponsePage.getTotalPages(), ResponsePage.hasNext(), ResponsePage.hasPrevious(), nextPageUrl, previousPageUrl));
            response.setRspData(content);
            return response;

        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }


    @Override
    public EntyRecgaleriarecmaResponse getAll(int currentPage , int totalPageSize , String parameter, String filter) throws EBusinessException {
        try {
            currentPage = currentPage - 1;
            Pageable pageable = PageRequest.of(currentPage, totalPageSize);
            Page<EntyRecgaleriarecma> ResponsePage = null;

            if (parameter.equals("FKEY")) {
                ResponsePage = repository.findByIdHomePageArtist(filter, pageable);
            }
            else
            {
                // PKEY
                ResponsePage = repository.findByRecUnikeyRegl(Integer.parseInt(filter),pageable);
            }

            List<EntyRecgaleriarecma> ListPage = ResponsePage.getContent();
            List<EntyRecgaleriarecmaDto> content  = ListPage.stream().map(p ->mapToDto(p)).collect(Collectors.toList());

            EntyRecgaleriarecmaResponse response = new EntyRecgaleriarecmaResponse();
            response.setRspMessage(response.getRspMessage());
            response.setRspValue(response.getRspValue());

            currentPage = currentPage + 1;
            String nextPageUrl = "LocalHost";
            String previousPageUrl = "LocalHost";
            response.setRspPagination(headResponse(currentPage, content.size(), 
                                                   ResponsePage.getTotalElements(), 
                                                   ResponsePage.getTotalPages(), 
                                                   ResponsePage.hasNext(), 
                                                   ResponsePage.hasPrevious(), 
                                                   nextPageUrl, 
                                                   previousPageUrl));
            response.setRspData(content);
            return response;


        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }
    @Override
    public EntyRecgaleriarecmaDto get(Integer id) throws EBusinessException {
        try {
            return saveResponseTranslate.translate(repository.findById(id).get());
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntyRecgaleriarecmaDto save(EntyRecgaleriarecmaDto dto) throws EBusinessException {
        try {
            return saveResponseTranslate.translate(repository.save(dtoToEntityTranslate.translate(dto)));
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public List<EntyRecgaleriarecmaDto> save(List<EntyRecgaleriarecmaDto> dtos) throws EBusinessException {
        try {
            List<EntyRecgaleriarecma> entities = new ArrayList<>();

            for (EntyRecgaleriarecmaDto dto : dtos) {
                entities.add(dtoToEntityTranslate.translate(dto));
            }
            dtos = new ArrayList<>();
            for (EntyRecgaleriarecma entity : repository.saveAll(entities)) {
                dtos.add(saveResponseTranslate.translate(entity));
            }
            return dtos;
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntyRecgaleriarecmaDto update(Integer id, EntyRecgaleriarecmaDto dto) throws EBusinessException {
        try {
            EntyRecgaleriarecma entity = dtoToEntityTranslate.translate(dto);
            EntyRecgaleriarecma old = repository.findById(id).get();

            old.setRecUnikeyRegl(
                    Objects.nonNull(dto.getRecUnikeyRegl())&& !entity.getRecUnikeyRegl().equals(0)
                            ? entity.getRecUnikeyRegl()
                            :old.getRecUnikeyRegl());

            old.setRecNroregRegl(
                    Objects.nonNull(dto.getRecNroregRegl())&& !entity.getRecNroregRegl().isEmpty()
                            ? entity.getRecNroregRegl()
                            :old.getRecNroregRegl());

            old.setApjNroregAphp(
                    Objects.nonNull(dto.getApjNroregAphp())&& !entity.getApjNroregAphp().isEmpty()
                            ? entity.getApjNroregAphp()
                            :old.getApjNroregAphp());


            old.setRecObservRegl(
                    Objects.nonNull(dto.getRecObservRegl())&& !entity.getRecObservRegl().isEmpty()
                            ? entity.getRecObservRegl()
                            :old.getRecObservRegl());

            old.setRecGrprecRegr(
                    Objects.nonNull(dto.getRecGrprecRegr())&& !entity.getRecGrprecRegr().isEmpty()
                            ? entity.getRecGrprecRegr()
                            :old.getRecGrprecRegr());

            old.setRecTiprecRegl(
                    Objects.nonNull(dto.getRecTiprecRegl())&& !entity.getRecTiprecRegl().isEmpty()
                            ? entity.getRecTiprecRegl()
                            :old.getRecTiprecRegl());


            old.setRecNomrecRegl(
                    Objects.nonNull(dto.getRecNomrecRegl())&& !entity.getRecNomrecRegl().isEmpty()
                            ? entity.getRecNomrecRegl()
                            :old.getRecNomrecRegl());

            old.setRecOrdvisRegl(
                    Objects.nonNull(dto.getRecOrdvisRegl())&& !entity.getRecOrdvisRegl().equals(0)
                            ? entity.getRecOrdvisRegl()
                            :old.getRecOrdvisRegl());

            old.setRecDrwpinRegl(
                    Objects.nonNull(dto.getRecDrwpinRegl())&& !entity.getRecDrwpinRegl().equals(0)
                            ? entity.getRecDrwpinRegl()
                            :old.getRecDrwpinRegl());

            old.setRecRecax1Regl(
                    Objects.nonNull(dto.getRecRecax1Regl())&& !entity.getRecRecax1Regl().isEmpty()
                            ? entity.getRecRecax1Regl()
                            :old.getRecRecax1Regl());

            old.setRecRecax2Regl(
                    Objects.nonNull(dto.getRecRecax2Regl())&& !entity.getRecRecax2Regl().isEmpty()
                            ? entity.getRecRecax2Regl()
                            :old.getRecRecax2Regl());

            old.setRecRecax3Regl(
                    Objects.nonNull(dto.getRecRecax3Regl())&& !entity.getRecRecax3Regl().isEmpty()
                            ? entity.getRecRecax3Regl()
                            :old.getRecRecax3Regl());

            old.setRecFecrecRegl(
                    Objects.nonNull(dto.getRecFecrecRegl())&& !entity.getRecFecrecRegl().equals(0)
                            ? entity.getRecFecrecRegl()
                            :old.getRecFecrecRegl());

            old.setRecHorrecRegl(
                    Objects.nonNull(dto.getRecHorrecRegl())&& !entity.getRecHorrecRegl().equals(0)
                            ? entity.getRecHorrecRegl()
                            :old.getRecHorrecRegl());

            old.setRecRllaveRegl(
                    Objects.nonNull(dto.getRecRllaveRegl())&& !entity.getRecRllaveRegl().equals(0)
                            ? entity.getRecRllaveRegl()
                            :old.getRecRllaveRegl());

            old.setRecEstregRegl(
                    Objects.nonNull(dto.getRecEstregRegl())&& !entity.getRecEstregRegl().equals(0)
                            ? entity.getRecEstregRegl()
                            :old.getRecEstregRegl());


            return saveResponseTranslate.translate(repository.save(old));
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.UPDATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.UPDATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();

        }
    }

    @Override
    public void delete(Integer id) throws EBusinessException {
        try {
            repository.delete(repository.findById(id).get());
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.DELETE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.DELETE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    private EntyRecgaleriarecmaDto mapToDto(EntyRecgaleriarecma entyRecgaleriarecma){
        EntyRecgaleriarecmaDto dto = new EntyRecgaleriarecmaDto();

        dto.setRecUnikeyRegl(entyRecgaleriarecma.getRecUnikeyRegl());
        dto.setRecNroregRegl(entyRecgaleriarecma.getRecNroregRegl());
        dto.setApjNroregAphp(entyRecgaleriarecma.getApjNroregAphp());
        dto.setRecObservRegl(entyRecgaleriarecma.getRecObservRegl());
        dto.setRecGrprecRegr(entyRecgaleriarecma.getRecGrprecRegr());
        dto.setRecTiprecRegl(entyRecgaleriarecma.getRecTiprecRegl());
        dto.setRecNomrecRegl(entyRecgaleriarecma.getRecNomrecRegl());
        dto.setRecOrdvisRegl(entyRecgaleriarecma.getRecOrdvisRegl());
        dto.setRecDrwpinRegl(entyRecgaleriarecma.getRecDrwpinRegl());
        dto.setRecRecax1Regl(entyRecgaleriarecma.getRecRecax1Regl());
        dto.setRecRecax2Regl(entyRecgaleriarecma.getRecRecax2Regl());
        dto.setRecRecax3Regl(entyRecgaleriarecma.getRecRecax3Regl());
        dto.setRecFecrecRegl(entyRecgaleriarecma.getRecFecrecRegl());
        dto.setRecHorrecRegl(entyRecgaleriarecma.getRecHorrecRegl());
        dto.setRecRllaveRegl(entyRecgaleriarecma.getRecRllaveRegl());
        dto.setRecEstregRegl(entyRecgaleriarecma.getRecEstregRegl());
        return  dto;
    }

    public static PaginationResponse headResponse(int currentPage    , int totalPageSize ,
                                                  long totalResults  , int totalPages,
                                                  boolean hasNextPage, boolean hasPreviousPage,
                                                  String nextpageUrl , String previousPageUrl )
    {
        return PaginationResponse.builder()
                .currentPage(currentPage)
                .totalPageSize(totalPageSize)
                .totalResults(totalResults)
                .totalPages(totalPages)
                .hasNextPage(hasNextPage)
                .hasPreviousPage(hasPreviousPage)
                .nextPageUrl(nextpageUrl)
                .previousPageUrl(previousPageUrl)
                .build();

    }
}
