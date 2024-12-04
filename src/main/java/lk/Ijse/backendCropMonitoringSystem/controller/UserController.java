package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dto.UserStatus;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.UserDTO;
import lk.Ijse.backendCropMonitoringSystem.exception.DataPersistException;
import lk.Ijse.backendCropMonitoringSystem.service.UserService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(
           @RequestPart ("firstName") String firstName,
           @RequestPart ("lastName") String lastName,
           @RequestPart ("email") String email,
           @RequestPart ("password") String password
    ) {
        try {
            //UserId generate
            String userId = AppUtil.generateUserId();
            UserDTO buildUserDTO = new UserDTO();
            buildUserDTO.setUserId(userId);
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);
            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasRole('MANAGER')")
    public UserStatus getSelectedUser(@PathVariable ("userId") String userId){
        return userService.getUser(userId);
    }
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId){

            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
       return userService.getAllUsers();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateUser(
            @RequestPart ("firstName") String firstName,
            @RequestPart ("lastName") String lastName,
            @RequestPart ("email") String email,
            @RequestPart ("password") String password,
            @PathVariable ("userId") String userId
    ){
        // profilePic ----> Base64

        //Build the Object
        UserDTO buildUserDTO = new UserDTO();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        userService.updateUser(userId,buildUserDTO);
    }


}
