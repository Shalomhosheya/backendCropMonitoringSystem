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

import java.util.List;
import java.util.Optional;
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

    @Override
    public List<FieldDTO> getAllFields() {
        return fieldmapping.asFieldDTOList(fieldDAO.findAll());
    }

    @Override
    public void deleteField(String fieldID) {
         Optional<FieldEntity>field=fieldDAO.findById(fieldID);
        if (!field.isPresent()) {
            System.out.println("not found");
        }else {
            fieldDAO.deleteById(fieldID);
        }
    }

    @Override
    public void updateFile(String fieldID, FieldDTO fieldDTO) {
        Optional<FieldEntity> findField=fieldDAO.findById(fieldID);
        if (!findField.isPresent()){
            System.out.println("no content");
        }else {
            findField.get().setFieldName(fieldDTO.getFieldName());
            findField.get().setFieldLocation(fieldDTO.getFieldLocation());
            findField.get().setFieldSize(fieldDTO.getFieldSize());
            findField.get().setStaff(fieldDTO.getStaff());
            findField.get().setPicture(fieldDTO.getPicture());
            findField.get().setPicture2(fieldDTO.getPicture2());
        }

    }
}
