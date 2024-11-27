package lk.Ijse.backendCropMonitoringSystem.service.impl;

import jakarta.transaction.Transactional;
import lk.Ijse.backendCropMonitoringSystem.dao.UserDao;
import lk.Ijse.backendCropMonitoringSystem.dto.UserStatus;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.UserDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.UserEntity;
import lk.Ijse.backendCropMonitoringSystem.exception.DataPersistException;
import lk.Ijse.backendCropMonitoringSystem.exception.UserNotFoundException;
import lk.Ijse.backendCropMonitoringSystem.service.UserService;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping userMapping;




    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity savedUser =
                userDao.save(userMapping.toUserEntity(userDTO));
        if (savedUser == null) {
            throw new DataPersistException("User not saved");
        }
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = userDao.findAll();
        return userMapping.asUserDTOList(allUsers);
    }

    @Override
    public UserStatus getUser(String userId) {
          UserEntity selectedUser = userDao.getReferenceById(userId);
            return userMapping.toUserDTO(selectedUser);

    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> existedUser = userDao.findById(userId);

            userDao.deleteById(userId);

    }

    @Override
    public UserDetailsService userDetailsServices() {
        return  username -> userDao.findByEmail(username)
                .orElseThrow(()->new UserNotFoundException("User not found"));
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDao.findById(userId);
        if(tmpUser.isPresent()) {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
        }
    }

    /*@Override
    public UserDetailsService userDetailsServices() {
        return  username -> userDao.findByEmail(username)
                .orElseThrow(()->new UserNotFoundException("User not found"));
    }*/
}
