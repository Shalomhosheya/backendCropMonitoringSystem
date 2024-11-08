package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private String vehicleID;
    private String vehicleCategory;
    private String fuelType;
    private String remarks;
    private String status;
    private String licenseNumberPlate;
    private String staffID;
}
