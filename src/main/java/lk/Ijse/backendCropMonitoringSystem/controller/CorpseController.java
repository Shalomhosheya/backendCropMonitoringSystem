package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.CorpseDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.CorpseEntity;
import lk.Ijse.backendCropMonitoringSystem.service.CorpseService;
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
@RequestMapping("api/vi/corpse")
@CrossOrigin
public class CorpseController {
    @Autowired
    private CorpseService corpseService;


    @PostMapping(value = "/save", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveCrops(
            @RequestPart("common_name") String common_name,
            @RequestPart("crop_scientific_name") String crop_scientific_name,
            @RequestPart("crop_image") MultipartFile crop_image,  // Change here
            @RequestPart("category") String category,
            @RequestPart("crop_season") String crop_season
    ) {
        String cropId = AppUtil.generateCorpseID();
        String base64 = "";

        try {
            byte[] bytesPicture1 = crop_image.getBytes();
            base64 = AppUtil.cropPic(bytesPicture1);

            CorpseDTO corpseDTO = new CorpseDTO();
            corpseDTO.setCorpseID(cropId);
            corpseDTO.setCommon_name(common_name);
            corpseDTO.setCrop_scientific_name(crop_scientific_name);
            corpseDTO.setCrop_image(base64);
            corpseDTO.setCategory(category);
            corpseDTO.setCrop_season(crop_season);

            corpseService.saveCrops(corpseDTO);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception if the file can't be read
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CorpseDTO> getAllCrops(){
        return corpseService.getAllCrops();
    }

    @PutMapping("/{corpseID}")
    public ResponseEntity<Void>updateCropsField(@PathVariable("corpseID")String crops_id,@RequestBody CorpseDTO corpseDTO){
        corpseService.updateAllCrops(crops_id,corpseDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("{corpseID}")
    public ResponseEntity<Void>deleteCropsField(@PathVariable("corpseID")String crops_id){
        corpseService.deleteCropsFields(crops_id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
