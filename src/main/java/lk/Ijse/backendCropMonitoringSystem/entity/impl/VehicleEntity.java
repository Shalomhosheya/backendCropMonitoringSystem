package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Vehicle")
public class VehicleEntity {
    @Id
    private String vehicleID;
    private String vehicleCategory;
    private String fuelType;
    private String remarks;
    private String status;
    private String licenseNumberPlate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_Id",nullable = false)
    private StaffEntity staffID;


    public void setStaffID(String staffID) {

    }
}
