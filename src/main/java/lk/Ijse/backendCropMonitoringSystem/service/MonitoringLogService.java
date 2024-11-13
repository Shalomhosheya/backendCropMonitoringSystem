package lk.Ijse.backendCropMonitoringSystem.service;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.MonitoringLogDTO;

import java.util.List;


public interface MonitoringLogService {
    void saveData(MonitoringLogDTO monitoringLogDTO);

    List<MonitoringLogDTO> getAllData();

    void updateData(String id, MonitoringLogDTO monitoringLogDTO);
}
