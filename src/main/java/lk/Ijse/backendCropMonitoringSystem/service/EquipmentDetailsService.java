package lk.Ijse.backendCropMonitoringSystem.service;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.EquipmentDetailsDto;

import java.util.List;

public interface EquipmentDetailsService {
    void saveData(EquipmentDetailsDto equipmentDetailsDto);

    List<EquipmentDetailsDto> getAllData();

    void updateData(String id,EquipmentDetailsDto equipmentDetailsDto);

    void deleteData(String id);
}
