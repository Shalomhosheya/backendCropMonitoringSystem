package lk.Ijse.backendCropMonitoringSystem.service.impl;

import jakarta.transaction.Transactional;
import lk.Ijse.backendCropMonitoringSystem.dao.EqupmentDAO;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.EquipmentDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.EquipmentEntity;
import lk.Ijse.backendCropMonitoringSystem.service.EquipmentService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EquipmentServiceimpl implements EquipmentService {

    @Autowired
    private Mapping equip_mapper;

    @Autowired
    private EqupmentDAO equipmentDAO;
    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        equipmentDTO.setEquip_id(AppUtil.generateEquipmentID());
        EquipmentEntity equipmentEntity = equipmentDAO.save(equip_mapper.toEquipEntity(equipmentDTO));
        if (equipmentEntity == null) {
            System.out.println("equipEntity is null");
        }
    }

    @Override
    public List<EquipmentDTO> getallData() {
        return equip_mapper.asEquipDTOList(equipmentDAO.findAll());
    }
}
