package lk.Ijse.backendCropMonitoringSystem.service;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.VehicleDTO;

import java.util.List;

public interface VehicleService {

    void saveVehicle(VehicleDTO vehicleDTO);

    List<VehicleDTO> getAllData();

    void deleteData(String vId);

    void updateData(String vId,VehicleDTO vehicleDTO);
}
