package lk.Ijse.backendCropMonitoringSystem.service.impl;

import jakarta.transaction.Transactional;
import lk.Ijse.backendCropMonitoringSystem.dao.EquipmentDetailsDAO;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.EquipmentDetailsDto;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.EquipmentDetailsEntity;
import lk.Ijse.backendCropMonitoringSystem.service.EquipmentDetailsService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipmentDetailsServiceimpl implements EquipmentDetailsService {

    @Autowired
    private EquipmentDetailsDAO equipmentDetailsDAO;

    @Autowired
    private Mapping equipment_detail_mapping;
    @Override
    public void saveData(EquipmentDetailsDto equipmentDetailsDto) {
        equipmentDetailsDto.setEquip_detailsID(AppUtil.generateEquipmentID());
        EquipmentDetailsEntity equipmentDetailsEntity = equipmentDetailsDAO.save(equipment_detail_mapping.toEquipmentdetailEntity(equipmentDetailsDto));
        System.out.println("clicked");
        if (equipmentDetailsEntity == null) {
            System.out.println("equipmentDetailsentity is null");
        }
    }

    @Override
    public List<EquipmentDetailsDto> getAllData() {
        return equipment_detail_mapping.asEquipDetailDtoList(equipmentDetailsDAO.findAll());
    }

    @Override
    public void updateData(String id, EquipmentDetailsDto equipmentDetailsDto) {
        Optional<EquipmentDetailsEntity>equipmentDetailsEntity = equipmentDetailsDAO.findById(id);
        if (!equipmentDetailsEntity.isPresent()) {
            System.out.println("equipmentDetailsEntity");
        }else {
            EquipmentDetailsEntity update = equipment_detail_mapping.toEquipmentdetailEntity(equipmentDetailsDto);
            equipmentDetailsEntity.get().setEquipment(update.getEquipment());
            equipmentDetailsEntity.get().setStaff(update.getStaff());
            equipmentDetailsEntity.get().setResone(update.getResone());
            equipmentDetailsEntity.get().setField(update.getField());
            equipmentDetailsEntity.get().setDate(update.getDate());
        }
    }


}
