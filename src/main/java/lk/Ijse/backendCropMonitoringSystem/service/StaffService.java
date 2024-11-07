package lk.Ijse.backendCropMonitoringSystem.service;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.StaffDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.StaffEntity;

import java.util.List;

public interface StaffService {
    void savestaff(StaffDTO staffDTO);

    List<StaffDTO> getAllStaffFields();

    void deleteData(String staffID);

    void updateStaff(String staffId, StaffDTO staffDTO);
}
