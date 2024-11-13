package lk.Ijse.backendCropMonitoringSystem.dto.impl;

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
