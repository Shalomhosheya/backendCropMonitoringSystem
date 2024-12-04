package lk.Ijse.backendCropMonitoringSystem.service.impl;

import lk.Ijse.backendCropMonitoringSystem.dao.UserDao;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.UserDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.UserEntity;
import lk.Ijse.backendCropMonitoringSystem.secure.JWT_authResponse;
import lk.Ijse.backendCropMonitoringSystem.secure.SignIn;
import lk.Ijse.backendCropMonitoringSystem.service.AuthService;
import lk.Ijse.backendCropMonitoringSystem.service.JWT_Service;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserDao userDao;
    private final Mapping mapping;
    private final JWT_Service jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JWT_authResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
     var user=  userDao.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not Found"));
        var generatedToken = jwtService.generateToken(user);
        var email =signIn.getEmail();
        return JWT_authResponse.builder()
                .token(generatedToken)
                .email(email)  // Include email in the response
                .build();
    }

    @Override
    public JWT_authResponse signUp(UserDTO userDTO) {
         UserEntity saveUser= userDao.save(mapping.toUserEntity(userDTO));    //Save User
        var generateToken = jwtService.generateToken(saveUser);

        return JWT_authResponse.builder().token(generateToken).build();

    }

    @Override
    public JWT_authResponse refreshToken(String accessToken) {

     var userName=jwtService.extractUserName(accessToken);
       var finduser= userDao.findByEmail(userName).orElseThrow(()->new UsernameNotFoundException("User not Found"));
       var refreshToken = jwtService.refreshToken(finduser);
        return JWT_authResponse.builder().token(refreshToken).build();
    }
}
