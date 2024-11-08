package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.VehicleDTO;
import lk.Ijse.backendCropMonitoringSystem.exception.DataPersistException;
import lk.Ijse.backendCropMonitoringSystem.service.VehicleService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("api/v1/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping(value = "/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveVehicle(
            @RequestPart("vehicleCategory")String vehicleCategory,
            @RequestPart("fuelType")String fuelType,
            @RequestPart("remarks")String remarks,
            @RequestPart("status")String status,
            @RequestPart("licenseNumberPlate")String licenseNumberPlate,
            @RequestPart("staffID")String staffID
    ){
        try {

            VehicleDTO vehicleDTO = new VehicleDTO();
            String vehicleID=AppUtil.generateVehicleID();
            vehicleDTO.setVehicleID(vehicleID);
            vehicleDTO.setVehicleCategory(vehicleCategory);
            vehicleDTO.setFuelType(fuelType);
            vehicleDTO.setRemarks(remarks);
            vehicleDTO.setStatus(status);
            vehicleDTO.setLicenseNumberPlate(licenseNumberPlate);
            vehicleDTO.setStaffID(staffID);
            vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException d){
            d.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
