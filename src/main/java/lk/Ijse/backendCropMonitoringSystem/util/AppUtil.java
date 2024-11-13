package lk.Ijse.backendCropMonitoringSystem.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateFieldID(){
     return "Field"+ UUID.randomUUID();
    }
    public static String generateEquipmentDetails(){
     return "equip_details"+ UUID.randomUUID();
    }
    public static String generateReservationID(){
     return "reservation"+ UUID.randomUUID();
    }
    public static String generateCorpseID(){
     return "crops"+ UUID.randomUUID();
    }
    public static String generateMonitoringID(){
     return "monitoringLog"+ UUID.randomUUID();
    }
    public static String generateStaffID(){
     return "Staff"+ UUID.randomUUID();
    }
    public static String profilePicToBase64(byte [] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
    public static String monitoringPicToBase64(byte [] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
    public static String generateVehicleID(){
        return "Vehicle"+UUID.randomUUID();
    }
    public static String generateEquipmentID(){
        return "Equipment"+UUID.randomUUID();
    }

    public static String cropPic(byte[] bytesPicture1) {
        return Base64.getEncoder().encodeToString(bytesPicture1);
    }
}
