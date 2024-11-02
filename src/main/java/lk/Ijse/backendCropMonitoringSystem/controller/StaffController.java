package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.StaffDTO;
import lk.Ijse.backendCropMonitoringSystem.exception.DataPersistException;
import lk.Ijse.backendCropMonitoringSystem.service.StaffService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/v1/staff")
@CrossOrigin(origins = "http://localhost:63342")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping(value = "/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void>saveStaff(
            @RequestPart("firstName")String firstname,
            @RequestPart("lastName")String lastname,
            @RequestPart("designation")String designation,
            @RequestPart("gender")String gender,
            @RequestPart("joinDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date joinDate,
            @RequestPart("DOB")@DateTimeFormat(pattern = "yyyy-MM-dd") Date DOB,
            @RequestPart("role") String role,
            @RequestPart("field") String field,
            @RequestPart("vehicle") String vehicle
                                         ){

        try {

            String staffId = AppUtil.generateStaffID();
            StaffDTO staffDTO = new StaffDTO();
            staffDTO.setStaffID(staffId);
            staffDTO.setFirstName(firstname);
            staffDTO.setLastName(lastname);
            staffDTO.setDesignation(designation);
            staffDTO.setGender(gender);
            staffDTO.setJoinDate(joinDate);
            staffDTO.setDOB(DOB);
            staffDTO.setRole(role);
            staffDTO.setField(field);
            staffDTO.setVehicle(vehicle);

            staffService.savestaff(staffDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
