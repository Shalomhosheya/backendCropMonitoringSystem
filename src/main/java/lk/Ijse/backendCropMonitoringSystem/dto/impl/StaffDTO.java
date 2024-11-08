package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import lk.Ijse.backendCropMonitoringSystem.dto.StaffStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO implements StaffStatus {
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
    private String contactNum;
    private String role;
    private String email;
    private String field;

}
