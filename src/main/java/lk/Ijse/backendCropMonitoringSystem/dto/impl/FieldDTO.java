package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import lk.Ijse.backendCropMonitoringSystem.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO implements FieldStatus {
    private String fieldID;
    private String fieldName;
    private String fieldLocation;
    private String fieldSize;
    private String staff;
    private String picture;
    private String picture2;

    public void getFieldID(String s) {
    }
}
