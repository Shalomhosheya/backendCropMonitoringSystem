package lk.Ijse.backendCropMonitoringSystem.service;

import lk.Ijse.backendCropMonitoringSystem.dto.UserStatus;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserStatus getUser(String userId);
    void deleteUser(String userId);
    void updateUser(String userId, UserDTO userDTO);

    UserDetailsService userDetailsServices();
}
