package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private Date joinDate;
    private Date DOB;
    private String role;
    private String field;
    private String vehicle;
}
