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

}
