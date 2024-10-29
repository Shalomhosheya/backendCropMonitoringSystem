package lk.Ijse.backendCropMonitoringSystem.util;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.FieldDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.FieldEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Mapping {
    @Autowired
    private ModelMapper mapper;


    public FieldEntity toFieldEntity(FieldDTO fieldDTO) {
        return mapper.map(fieldDTO,FieldEntity.class);
     }
}
