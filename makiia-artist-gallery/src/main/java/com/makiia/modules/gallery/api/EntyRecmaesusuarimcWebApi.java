package com.makiia.modules.gallery.api;
import com.makiia.crosscutting.domain.constants.ApiConstants;
import com.makiia.crosscutting.domain.constants.Constants;
import com.makiia.crosscutting.domain.model.EntyDeleteDto;
import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaDto;
import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaResponse;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.exceptions.MicroEventException;
import com.makiia.modules.gallery.usecase.EntyRecgaleriarecmaService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/gallery", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EntyRecmaesusuarimcWebApi {
    @Autowired
    private EntyRecgaleriarecmaService service;
    @GetMapping("getall")
    @ApiOperation(httpMethod = ApiConstants.GET_HTTP, value = ApiConstants.GET_DESC, notes = "")
    public ResponseEntity<EntyRecgaleriarecmaResponse> getAll()
            throws EBusinessException, MicroEventException {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping
    @ApiOperation(httpMethod = ApiConstants.GET_HTTP, value = ApiConstants.GET_ALL_DESC, notes = "")
    public ResponseEntity<EntyRecgaleriarecmaResponse> getAll(@RequestParam(value = "currentpage",required = false,defaultValue = "0") int currentPage,
                                                              @RequestParam(value = "pagesize",required = false,defaultValue = "10")  int pagesize,
                                                              @RequestParam(value = "parameter",required = false) int parameter,
                                                              @RequestParam(value = "filter",required = false ) String filter)
     throws EBusinessException, MicroEventException {
          return new ResponseEntity<>(service.getAll(currentPage, pagesize, parameter ,filter), HttpStatus.OK);
    }
    @GetMapping(Constants.ID_PRICES_PARAM)
    @ApiOperation(httpMethod = ApiConstants.GET_HTTP, value = ApiConstants.GET_DESC, notes = "")
    public ResponseEntity<EntyRecgaleriarecmaDto>get(@PathVariable(Constants.ID_REST) Integer id)
            throws EBusinessException, MicroEventException {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping("create")
    @ApiOperation(httpMethod = ApiConstants.POST_HTTP, value = ApiConstants.POST_DESC, notes = "")
    public ResponseEntity<EntyRecgaleriarecmaResponse> create(@RequestBody EntyRecgaleriarecmaResponse dto)
            throws EBusinessException, MicroEventException {
        return new ResponseEntity<>(service.saveBefore(dto), HttpStatus.CREATED);
    }

    @PutMapping("update")
    @ApiOperation(httpMethod = ApiConstants.PUT_HTTP, value = ApiConstants.PUT_DESC, notes = "")
    public ResponseEntity<EntyRecgaleriarecmaResponse> update(@RequestBody EntyRecgaleriarecmaResponse dto)
            throws EBusinessException, MicroEventException {
        return new ResponseEntity<>(service.updateAll(dto), HttpStatus.CREATED);
    }

    @PatchMapping("drawingping")
    @ApiOperation(httpMethod = ApiConstants.PATCH_HTTP, value = ApiConstants.PATCH_DESC, notes = "")
    public String changestatus(@RequestBody List<EntyDeleteDto> dto) throws EBusinessException, MicroEventException {
        return service.changestatusAll(dto);
    }

    @DeleteMapping("delete")
    @ApiOperation(httpMethod = ApiConstants.DELETE_HTTP, value = ApiConstants.DELETE_DESC, notes = "")
    public String delete(@RequestBody List<EntyDeleteDto> dto) throws EBusinessException, MicroEventException {
        return service.deleteAll(dto);
    }

}