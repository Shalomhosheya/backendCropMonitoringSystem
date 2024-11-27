package lk.Ijse.backendCropMonitoringSystem.service;


import lk.Ijse.backendCropMonitoringSystem.dto.impl.UserDTO;
import lk.Ijse.backendCropMonitoringSystem.secure.JWT_authResponse;
import lk.Ijse.backendCropMonitoringSystem.secure.SignIn;

public interface AuthService {
    JWT_authResponse signIn(SignIn signIn);
    JWT_authResponse signUp(UserDTO userDTO);
    JWT_authResponse refreshToken(String accessToken);
}
