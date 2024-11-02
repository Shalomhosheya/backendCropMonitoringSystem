package lk.Ijse.backendCropMonitoringSystem.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateFieldID(){
     return "Field"+ UUID.randomUUID();
    }
    public static String generateStaffID(){
     return "Staff"+ UUID.randomUUID();
    }
    public static String profilePicToBase64(byte [] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
}
