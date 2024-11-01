package lk.Ijse.backendCropMonitoringSystem.service;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.FieldDTO;

import java.util.List;

public interface FieldService {
    void savesField(FieldDTO fieldDTO);

    List<FieldDTO> getAllFields();

    void deleteField(String fieldID);

    void updateFile(String fieldID, FieldDTO fieldDTO);
}
