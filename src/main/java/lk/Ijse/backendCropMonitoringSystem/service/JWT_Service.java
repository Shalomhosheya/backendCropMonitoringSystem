package lk.Ijse.backendCropMonitoringSystem.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWT_Service {
    String extractUserName(String token);
    String generateToken( UserDetails userDetails);
    boolean validateToken(String token,UserDetails userDetails);
    String refreshToken(UserDetails prevToken);
}
