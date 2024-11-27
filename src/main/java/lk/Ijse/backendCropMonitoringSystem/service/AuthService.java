package lk.Ijse.backendCropMonitoringSystem.service;

import lk.Ijse.GDSE.ADD67.Notecollector_V2.dto.impl.UserDTO;
import lk.Ijse.GDSE.ADD67.Notecollector_V2.secure.JWT_authResponse;
import lk.Ijse.GDSE.ADD67.Notecollector_V2.secure.SignIn;

public interface AuthService {
    JWT_authResponse signIn(SignIn signIn);
    JWT_authResponse signUp(UserDTO userDTO);
    JWT_authResponse refreshToken(String accessToken);
}
