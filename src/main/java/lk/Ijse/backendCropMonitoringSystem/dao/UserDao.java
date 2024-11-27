package lk.Ijse.backendCropMonitoringSystem.dao;

import lk.Ijse.backendCropMonitoringSystem.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
    Optional<UserEntity>findByEmail(String email);
}
