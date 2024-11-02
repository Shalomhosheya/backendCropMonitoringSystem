package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.FieldDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.FieldEntity;
import lk.Ijse.backendCropMonitoringSystem.exception.DataPersistException;
import lk.Ijse.backendCropMonitoringSystem.service.FieldService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import lk.Ijse.backendCropMonitoringSystem.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("api/v1/field")
@CrossOrigin(origins = "http://localhost:63342")
public class FieldController {
  @Autowired
  private FieldService fieldService;

    @PostMapping(value = "save")
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

        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
          e.printStackTrace();
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO>getAllFields(){
        return fieldService.getAllFields();
    }

    @DeleteMapping(value = "/{fieldID}")
   public ResponseEntity<Void>deleteField(@PathVariable("fieldID")String fieldID){
      /* if (!RegexProcess.fieldIDMatcher(fieldID)){
           System.out.println("regex error");
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }*/
        fieldService.deleteField(fieldID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = "/{fieldID}")
    public ResponseEntity<FieldEntity> updateField(@PathVariable("fieldID")String fieldID,@RequestBody FieldDTO fieldDTO){
        fieldService.updateFile(fieldID,fieldDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
