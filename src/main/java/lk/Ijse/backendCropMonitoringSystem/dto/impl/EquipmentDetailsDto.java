package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import lk.Ijse.backendCropMonitoringSystem.dto.EquipmentDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDetailsDto implements EquipmentDetailsStatus {

    private String equip_details;
    private String date;
    private String resone;
    private String staff_id;
    private String fieldID;
    private String staffID;
}
