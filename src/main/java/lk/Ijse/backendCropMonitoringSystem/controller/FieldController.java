package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.FieldDTO;
import lk.Ijse.backendCropMonitoringSystem.service.FieldService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.zip.DataFormatException;

@RestController
@RequestMapping("api/v1/field")
public class FieldController {
  @Autowired
  private FieldService fieldService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveField(
      @RequestPart("fieldName")String fieldName,
      @RequestPart("fieldloc")String fieldLoc,
      @RequestPart("fieldsize")String fieldSize,
      @RequestPart("fieldstaff")String fieldStaff,
      @RequestPart("fieldPic1") MultipartFile picture1,
      @RequestPart("fieldPic2")String picture2
    ){
        String base64_1="";
        String base64_2="";
        try {

            byte [] bytesPicture1 = picture1.getBytes();
            base64_1 =AppUtil.profilePicToBase64(bytesPicture1);
            byte [] bytesPicture2 = picture2.getBytes();
            base64_2 =AppUtil.profilePicToBase64(bytesPicture2);

            String fieldId= AppUtil.generateFieldID();
            FieldDTO fieldDTO = new FieldDTO();

            fieldDTO.setFieldID(fieldId);
            fieldDTO.setFieldLocation(fieldLoc);
            fieldDTO.setFieldName(fieldName);
            fieldDTO.setFieldSize(fieldSize);
            fieldDTO.setStaff(fieldStaff);
            fieldDTO.setPicture(base64_1);
            fieldDTO.setPicture2(base64_2);

            fieldService.savesField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
}
