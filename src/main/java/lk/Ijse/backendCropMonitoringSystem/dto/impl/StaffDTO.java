package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO {
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
