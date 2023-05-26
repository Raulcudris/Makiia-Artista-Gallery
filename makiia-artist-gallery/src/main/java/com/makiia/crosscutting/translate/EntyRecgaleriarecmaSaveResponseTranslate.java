package com.makiia.crosscutting.translate;
import com.makiia.crosscutting.domain.model.EntyRecgaleriarecmaDto;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntyRecgaleriarecma;
import com.makiia.crosscutting.utils.GsonUtil;
import org.springframework.stereotype.Component;
@Component
public class EntyRecgaleriarecmaSaveResponseTranslate implements Translator<EntyRecgaleriarecma, EntyRecgaleriarecmaDto> {
    @Override
    public EntyRecgaleriarecmaDto translate(EntyRecgaleriarecma input) throws EBusinessException {
        return GsonUtil.getGson().fromJson(GsonUtil.getGson().toJson(input), EntyRecgaleriarecmaDto.class);
    }
}
