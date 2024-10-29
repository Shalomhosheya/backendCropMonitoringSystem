package lk.Ijse.backendCropMonitoringSystem.service.impl;

import jakarta.transaction.Transactional;
import lk.Ijse.backendCropMonitoringSystem.dao.FieldDAO;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.FieldDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.FieldEntity;
import lk.Ijse.backendCropMonitoringSystem.service.FieldService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.zip.DataFormatException;

@Service
@Transactional
public class FieldServicesimpl implements FieldService {

    @Autowired
    private FieldDAO fieldDAO;

    @Autowired
    private Mapping fieldmapping;

    @Override
    public void savesField(FieldDTO fieldDTO) {
      fieldDTO.getFieldID(AppUtil.generateFieldID());
        FieldEntity saveField =
                fieldDAO.save(fieldmapping.toFieldEntity(fieldDTO));
        if (saveField==null){
            System.out.println("null value");
        }
    }
}
