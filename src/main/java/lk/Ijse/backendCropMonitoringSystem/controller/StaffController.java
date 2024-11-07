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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@RestController
@RequestMapping("api/v1/staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveStaff(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("designation") String designation,
            @RequestPart("gender") String gender,
            @RequestPart("address1") String address1,
            @RequestPart("address2") String address2,
            @RequestPart("address3") String address3,
            @RequestPart("address4") String address4,
            @RequestPart("address5") String address5,
            @RequestPart("joinDate") String joinDateStr, // Accept date as string
            @RequestPart("DOB") String dobStr, // Accept date as string
            @RequestPart("role") String role,
            @RequestPart("email") String email,
            @RequestPart("contacrnum") String contactNum,
            @RequestPart("field") String field)
           {

        try {
            // Parse dates
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date joinDate = dateFormat.parse(joinDateStr);
            Date dob = dateFormat.parse(dobStr);

            // Populate DTO
            String staffId = AppUtil.generateStaffID();
            StaffDTO staffDTO = new StaffDTO();
            staffDTO.setStaffID(staffId);
            staffDTO.setFirstName(firstName);
            staffDTO.setLastName(lastName);
            staffDTO.setDesignation(designation);
            staffDTO.setGender(gender);
            staffDTO.setAddress_1(address1);
            staffDTO.setAddress_2(address2);
            staffDTO.setAddress_3(address3);
            staffDTO.setAddress_4(address4);
            staffDTO.setAddress_5(address5);
            staffDTO.setJoinDate(joinDate);
            staffDTO.setDOB(dob);
            staffDTO.setRole(role);
            staffDTO.setContactNum(contactNum);
            staffDTO.setEmail(email);
            staffDTO.setField(field);

            staffService.savestaff(staffDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDTO> getAllData(){
        return staffService.getAllStaffFields();
    }

    @DeleteMapping(value = "/{staffID}")
    public ResponseEntity<Void>delete(@PathVariable("staffID")String staffID){
         staffService.deleteData(staffID);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = "/{staffID}")
    public ResponseEntity<Void>updateStaff(@PathVariable("staffID")String staffId,@RequestBody StaffDTO staffDTO){
        staffService.updateStaff(staffId,staffDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
