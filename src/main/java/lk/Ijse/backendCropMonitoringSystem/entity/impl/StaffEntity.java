package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.*;
import lk.Ijse.backendCropMonitoringSystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Staff")
public class StaffEntity implements SuperEntity {
    @Id
    private String staffID;
    private String firstName;
    private String LastName;
    private String designation;
    private String gender;
    private  String address_1;
    private  String address_2;
    private  String address_3;
    private  String address_4;
    private  String address_5;

    private Date joinDate;
    private Date DOB;
    private String role;
    private String contactNum;
    private String email;
    private String field;

    @OneToMany(mappedBy = "staffID")
    private List<VehicleEntity>vehicleEntities;

    @OneToOne(mappedBy = "staff", cascade = CascadeType.ALL)
    private EquipmentEntity equipmentEntity;
}
