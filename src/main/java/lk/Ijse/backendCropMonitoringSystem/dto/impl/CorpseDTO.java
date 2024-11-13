package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import lk.Ijse.backendCropMonitoringSystem.dto.CorpseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CorpseDTO implements CorpseStatus {
    private String corpseID;
    private String common_name;
    private String crop_scientific_name;
    private String crop_image;
    private String category;
    private String crop_season;



}
