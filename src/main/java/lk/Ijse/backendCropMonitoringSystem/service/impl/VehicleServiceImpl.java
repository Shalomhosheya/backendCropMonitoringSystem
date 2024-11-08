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

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<VehicleDTO> getAllData() {
        return vehicleMapping.asVehicleDTOList(vehicleDAO.findAll());
    }

    @Override
    public void deleteData(String vId) {
        Optional<VehicleEntity>vehicleEntity=vehicleDAO.findById(vId);
        if (!vehicleEntity.isPresent()) {
            System.out.println("vehicle Entity is Null");
        }else {
            vehicleDAO.deleteById(vId);
        }
    }

    @Override
    public void updateData(String vId, VehicleDTO vehicleDTO) {
        Optional<VehicleEntity>vehicleEntity=vehicleDAO.findById(vId);
        if (!vehicleEntity.isPresent()) {
            System.out.println("entity Is empty");
        }else {
            vehicleEntity.get().setVehicleCategory(vehicleDTO.getVehicleCategory());
            vehicleEntity.get().setStatus(vehicleDTO.getStatus());
            vehicleEntity.get().setFuelType(vehicleDTO.getFuelType());
            vehicleEntity.get().setRemarks(vehicleDTO.getRemarks());
            vehicleEntity.get().setLicenseNumberPlate(vehicleDTO.getLicenseNumberPlate());
            vehicleEntity.get().setStaffID(vehicleDTO.getStaffID());
        }
    }

}
