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
import java.util.Optional;

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

    @Override
    public void deleteData(String equipId) {
        Optional<EquipmentEntity>equipmentEntity=equipmentDAO.findById(equipId);
        if (!equipmentEntity.isPresent()) {
            System.out.println("equipment Entity is not present");
        }
        else {
            equipmentDAO.deleteById(equipId);
        }
    }

    @Override
    public void updateData(String equipId, EquipmentDTO equipmentDTO) {
        Optional<EquipmentEntity>equipmentEntity =equipmentDAO.findById(equipId);
        if (!equipmentEntity.isPresent()) {
            System.out.println("equipment entity is null");
        }else {
            equipmentEntity.get().setType(equipmentDTO.getType());
            equipmentEntity.get().setName(equipmentDTO.getName());
            equipmentEntity.get().setStatus(equipmentDTO.getStatus());
            equipmentEntity.get().setField(equipmentDTO.getFieldID());
            equipmentEntity.get().setStaff(equipmentDTO.getStaffID());
        }
    }
}
