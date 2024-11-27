package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import lk.Ijse.backendCropMonitoringSystem.dto.UserStatus;
import lk.Ijse.backendCropMonitoringSystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements UserStatus {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
