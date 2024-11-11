package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.*;
import lk.Ijse.backendCropMonitoringSystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Vehicle")
public class VehicleEntity implements SuperEntity {
    @Id
    private String vehicleID;
    private String vehicleCategory;
    private String fuelType;
    private String remarks;
    private String status;
    private String licenseNumberPlate;

    @OneToMany(mappedBy = "vehicleEntity")
    private List<ReservationEntity>reservationEntities;
}
