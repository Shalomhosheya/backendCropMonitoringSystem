package lk.Ijse.backendCropMonitoringSystem.service;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.CorpseDTO;

import java.util.List;

public interface CorpseService {
    void saveCrops(CorpseDTO corpseDTO);

    List<CorpseDTO> getAllCrops();

    void updateAllCrops(String cropsId, CorpseDTO corpseDTO);

    void deleteCropsFields(String cropsId);
}
