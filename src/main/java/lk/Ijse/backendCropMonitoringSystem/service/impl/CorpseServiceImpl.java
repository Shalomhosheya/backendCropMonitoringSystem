package lk.Ijse.backendCropMonitoringSystem.service.impl;

import jakarta.transaction.Transactional;
import lk.Ijse.backendCropMonitoringSystem.dao.CorpseDAO;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.CorpseDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.CorpseEntity;
import lk.Ijse.backendCropMonitoringSystem.service.CorpseService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CorpseServiceImpl implements CorpseService {
    @Autowired
    private CorpseDAO corpseDAO;

    @Autowired
    private Mapping cropsMapping;
    @Override
    public void saveCrops(CorpseDTO corpseDTO) {
        corpseDTO.setCorpseID(AppUtil.generateCorpseID());
        CorpseEntity corpseEntity = corpseDAO.save(cropsMapping.toCorpseEntity(corpseDTO));
        if (corpseEntity == null) {
            System.out.println("corpse entity is null");
        }
    }

    @Override
    public List<CorpseDTO> getAllCrops() {
        return cropsMapping.asCropsList(corpseDAO.findAll());
    }

    @Override
    public void updateAllCrops(String cropsId, CorpseDTO corpseDTO) {
        Optional<CorpseEntity>corpseEntity=corpseDAO.findById(cropsId);
        if (!corpseEntity.isPresent()) {
            System.out.println("no content");
        }else {
            corpseEntity.get().setCategory(corpseDTO.getCategory());
            corpseEntity.get().setCrop_season(corpseDTO.getCrop_season());
            corpseEntity.get().setCommon_name(corpseDTO.getCommon_name());
            corpseEntity.get().setCrop_image(corpseDTO.getCrop_image());
        }
    }

    @Override
    public void deleteCropsFields(String cropsId) {
        Optional<CorpseEntity> corpseEntity = corpseDAO.findById(cropsId);
        if (!corpseEntity.isPresent()) {
            System.out.println("crops entity is empty");
        }else {
            corpseDAO.deleteById(cropsId);
        }
    }
}
