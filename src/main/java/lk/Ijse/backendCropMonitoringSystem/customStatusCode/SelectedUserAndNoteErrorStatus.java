package lk.Ijse.backendCropMonitoringSystem.customStatusCode;

import lk.Ijse.backendCropMonitoringSystem.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus{
    private int statusCode;
    private String statusMessage;
}
