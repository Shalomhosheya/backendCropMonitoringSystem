package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.EquipmentDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.EquipmentEntity;
import lk.Ijse.backendCropMonitoringSystem.exception.DataPersistException;
import lk.Ijse.backendCropMonitoringSystem.service.EquipmentService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipment")
@CrossOrigin(origins = "http://localhost:63342")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @PostMapping(value = "/save")
    public ResponseEntity<Void>saveEquipment(
            @RequestPart("name")String name,
            @RequestPart("type")String type,
            @RequestPart("status")String status
            ){
        try {

            String equip_ID= AppUtil.generateEquipmentID();
            EquipmentDTO equipmentDTO=new EquipmentDTO();
            equipmentDTO.setEquip_id(equip_ID);
            equipmentDTO.setName(name);
            equipmentDTO.setType(type);
            equipmentDTO.setStatus(status);
            equipmentService.saveEquipment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<EquipmentDTO>getAllData(){
        return equipmentService.getallData();
    }

    @DeleteMapping(value = "/{equip_id}")
    private ResponseEntity<Void>deleteData(@PathVariable("equip_id")String equip_id){
        equipmentService.deleteData(equip_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{equip_id}")
    private ResponseEntity<Void>updateData(@PathVariable("equip_id")String equip_id,@RequestBody EquipmentDTO equipmentDTO){
        equipmentService.updateData(equip_id,equipmentDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
