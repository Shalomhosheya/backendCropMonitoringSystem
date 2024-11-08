package lk.Ijse.backendCropMonitoringSystem.dao;

import lk.Ijse.backendCropMonitoringSystem.entity.impl.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<VehicleEntity,String> {
}
