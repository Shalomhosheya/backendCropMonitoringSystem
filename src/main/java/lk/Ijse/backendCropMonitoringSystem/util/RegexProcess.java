package lk.Ijse.backendCropMonitoringSystem.util;

import java.util.regex.Pattern;

public class RegexProcess {
    public static boolean fieldIDMatcher(String fieldID){
        String regexForUserID = "^Field-?[a-fA-F0-9]{8}[a-fA-F0-9]{4}[a-fA-F0-9]{4}[a-fA-F0-9]{4}[a-fA-F0-9]{12}$\n";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        return regexPattern.matcher(fieldID).matches();
    }
}
