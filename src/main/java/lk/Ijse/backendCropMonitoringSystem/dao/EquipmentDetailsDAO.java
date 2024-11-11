package lk.Ijse.backendCropMonitoringSystem.dao;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.EquipmentDetailsDto;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.EquipmentDetailsEntity;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDetailsDAO extends JpaRepository<EquipmentDetailsEntity,String> {
}
