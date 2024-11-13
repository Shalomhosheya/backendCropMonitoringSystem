package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.MonitoringLogDTO;
import lk.Ijse.backendCropMonitoringSystem.service.MonitoringLogService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/vi/monitoringLog")
@CrossOrigin
public class MonitoringLogController {
    @Autowired
    private MonitoringLogService monitoringLogService;

    @PostMapping(value = "save")
    private ResponseEntity<Void>saveDData(
            @RequestPart("log_Date")String log_Date,
            @RequestPart("observation")String observation,
            @RequestPart("observed_image") MultipartFile observed_image,
            @RequestPart("staffID")String staffID,
            @RequestPart("fieldID")String fieldID,
            @RequestPart("corpseID")String corpseID
    ){
        try {

            String base64="";

            byte [] bytesPicture1 = new byte[0];
            bytesPicture1 = observed_image.getBytes();
            base64 =AppUtil.monitoringPicToBase64(bytesPicture1);

            String id= AppUtil.generateMonitoringID();
            MonitoringLogDTO monitoringLogDTO =new MonitoringLogDTO();
            monitoringLogDTO.setMonitoringL_id(id);
            monitoringLogDTO.setLog_Date(log_Date);
            monitoringLogDTO.setObservation(observation);
            monitoringLogDTO.setObserved_image(base64);
            monitoringLogDTO.setStaffID(staffID);
            monitoringLogDTO.setFieldID(fieldID);
            monitoringLogDTO.setCorpseID(corpseID);

//            System.out.println(monitoringLogDTO.toString());

            monitoringLogService.saveData(monitoringLogDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    private List<MonitoringLogDTO>getAllData(){
       return monitoringLogService.getAllData();
    }
    @PutMapping(value = "{monitoringL_id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private ResponseEntity<Void>updateData(
            @RequestPart("log_Date")String log_Date,
            @RequestPart("observation")String observation,
            @RequestPart("observed_image") MultipartFile observed_image,
            @RequestPart("staffID")String staffID,
            @RequestPart("fieldID")String fieldID,
            @RequestPart("corpseID")String corpseID
            ){
        try {
            String base64="";

            byte [] bytesPicture1 = new byte[0];

            bytesPicture1 = observed_image.getBytes();

            base64 =AppUtil.monitoringPicToBase64(bytesPicture1);

            String id= AppUtil.generateMonitoringID();
            MonitoringLogDTO monitoringLogDTO =new MonitoringLogDTO();
            monitoringLogDTO.setMonitoringL_id(id);
            monitoringLogDTO.setLog_Date(log_Date);
            monitoringLogDTO.setObservation(observation);
            monitoringLogDTO.setObserved_image(base64);
            monitoringLogDTO.setStaffID(staffID);
            monitoringLogDTO.setFieldID(fieldID);
            monitoringLogDTO.setCorpseID(corpseID);

            monitoringLogService.updateData(id,monitoringLogDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
