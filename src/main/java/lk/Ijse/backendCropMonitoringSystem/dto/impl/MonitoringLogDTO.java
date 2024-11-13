package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.CorpseEntity;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.FieldEntity;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.StaffEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonitoringLogDTO {
    private String monitoringL_id;
    private String log_Date;
    private String observation;
    private String observed_image;

    private String staffID;
    private String fieldID;
    private String corpseID;


}
