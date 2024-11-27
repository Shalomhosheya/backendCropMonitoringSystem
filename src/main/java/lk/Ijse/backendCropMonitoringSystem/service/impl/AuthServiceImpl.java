package lk.Ijse.backendCropMonitoringSystem.service.impl;

import lk.Ijse.GDSE.ADD67.Notecollector_V2.dao.UserDao;
import lk.Ijse.GDSE.ADD67.Notecollector_V2.dto.impl.UserDTO;
import lk.Ijse.GDSE.ADD67.Notecollector_V2.entity.impl.UserEntity;
import lk.Ijse.GDSE.ADD67.Notecollector_V2.secure.JWT_authResponse;
import lk.Ijse.GDSE.ADD67.Notecollector_V2.secure.SignIn;
import lk.Ijse.GDSE.ADD67.Notecollector_V2.service.AuthService;
import lk.Ijse.GDSE.ADD67.Notecollector_V2.service.JWT_Service;
import lk.Ijse.GDSE.ADD67.Notecollector_V2.util.Mapping;
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
        return JWT_authResponse.builder().token(generatedToken).build();


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
