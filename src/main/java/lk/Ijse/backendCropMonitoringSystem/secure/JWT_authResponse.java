package lk.Ijse.backendCropMonitoringSystem.secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JWT_authResponse {
    private String token;
    private String email;

}
