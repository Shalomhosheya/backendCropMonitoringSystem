package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dao.EquipmentDetailsDAO;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.EquipmentDetailsDto;
import lk.Ijse.backendCropMonitoringSystem.service.EquipmentDetailsService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/equip_details")
@CrossOrigin
public class EquipmentDetailsController {

    @Autowired
    private EquipmentDetailsService equipmentDetailsService;

    @PostMapping(value = "/save", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> savedData(
            @RequestPart("date") String date,
            @RequestPart("resone") String resone,
            @RequestPart("staff_id") String staff_id,
            @RequestPart("fieldID") String fieldID,
            @RequestPart("equip_id") String equip_id
    ) {
        String id = AppUtil.generateEquipmentDetails();
        EquipmentDetailsDto equipmentDetailsDto = new EquipmentDetailsDto();

        equipmentDetailsDto.setEquip_detailsID(id);
        equipmentDetailsDto.setDate(date);
        equipmentDetailsDto.setResone(resone);
        equipmentDetailsDto.setStaffID(staff_id);
        equipmentDetailsDto.setFieldID(fieldID);
        equipmentDetailsDto.setEquip_id(equip_id);

        // Save the equipment details with equipment entity in service layer
        equipmentDetailsService.saveData(equipmentDetailsDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public List<EquipmentDetailsDto>getAlldata(){
        return equipmentDetailsService.getAllData();
    }
    @PutMapping(value = "/{equip_detailsID}",produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void>updateData(
                                          @RequestPart("date") String date,
                                          @RequestPart("resone") String resone,
                                          @RequestPart("staff_id") String staff_id,
                                          @RequestPart("fieldID") String fieldID,
                                          @RequestPart("equip_id") String equip_id
                                          ){
        EquipmentDetailsDto equipmentDetailsDto = new EquipmentDetailsDto();
        String id = AppUtil.generateEquipmentDetails();

        equipmentDetailsDto.setEquip_detailsID(id);
        equipmentDetailsDto.setDate(date);
        equipmentDetailsDto.setResone(resone);
        equipmentDetailsDto.setStaffID(staff_id);
        equipmentDetailsDto.setFieldID(fieldID);
        equipmentDetailsDto.setEquip_id(equip_id);
        equipmentDetailsService.updateData(id,equipmentDetailsDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(value = "{equip_detailsID}")
    private ResponseEntity<Void>deleteData(@PathVariable("equip_detailsID")String id){

        equipmentDetailsService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
