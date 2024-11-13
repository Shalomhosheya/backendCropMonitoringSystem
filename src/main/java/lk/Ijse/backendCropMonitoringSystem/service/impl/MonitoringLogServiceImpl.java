package lk.Ijse.backendCropMonitoringSystem.service.impl;

import jakarta.transaction.Transactional;
import lk.Ijse.backendCropMonitoringSystem.dao.MonitoringLogDAO;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.MonitoringLogDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.MonitoringLogEntity;
import lk.Ijse.backendCropMonitoringSystem.service.MonitoringLogService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonitoringLogServiceImpl implements MonitoringLogService {
    @Autowired
    private MonitoringLogDAO monitoringLogDAO;

    @Autowired
    private Mapping monitoringMapping;
    @Override
    public void saveData(MonitoringLogDTO monitoringLogDTO) {
        monitoringLogDTO.setMonitoringL_id(AppUtil.generateMonitoringID());
        MonitoringLogEntity monitoringLogEntity = monitoringLogDAO.save(monitoringMapping.tomonitoringLogEntity(monitoringLogDTO));
        if (monitoringLogEntity == null) {
            System.out.println("monitoringLogEntity");
        }
    }

    @Override
    public List<MonitoringLogDTO> getAllData() {
        return monitoringMapping.asMonitoringList(monitoringLogDAO.findAll());
    }


}
