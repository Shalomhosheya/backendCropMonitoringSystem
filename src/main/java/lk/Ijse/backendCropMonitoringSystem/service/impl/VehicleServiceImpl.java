package lk.Ijse.backendCropMonitoringSystem.service.impl;

import jakarta.transaction.Transactional;
import lk.Ijse.backendCropMonitoringSystem.dao.VehicleDAO;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.VehicleDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.VehicleEntity;
import lk.Ijse.backendCropMonitoringSystem.service.VehicleService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDAO vehicleDAO;
    @Autowired
    private Mapping vehicleMapping;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        vehicleDTO.setVehicleID(AppUtil.generateVehicleID());
        VehicleEntity vehicleEntity = vehicleDAO.save(vehicleMapping.toVehicleEntity(vehicleDTO));
        if (vehicleEntity == null) {
            System.out.println("vehicleEntity is null");
        }
    }
}
