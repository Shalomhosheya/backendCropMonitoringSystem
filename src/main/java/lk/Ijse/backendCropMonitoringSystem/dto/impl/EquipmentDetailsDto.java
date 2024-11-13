package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import lk.Ijse.backendCropMonitoringSystem.dto.EquipmentDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDetailsDto implements EquipmentDetailsStatus {

    private String equip_detailsID;
    private String date;
    private String resone;
    private String equip_id;
    private String staffID;
    private String fieldID;
}
