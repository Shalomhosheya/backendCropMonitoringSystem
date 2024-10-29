package lk.Ijse.backendCropMonitoringSystem.dao;

import lk.Ijse.backendCropMonitoringSystem.entity.impl.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDAO extends JpaRepository<FieldEntity,String> {
}
