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
        System.out.println(monitoringMapping.tomonitoringLogEntity(monitoringLogDTO).toString());
        MonitoringLogEntity monitoringLogEntity = monitoringLogDAO.save(monitoringMapping.tomonitoringLogEntity(monitoringLogDTO));
        if (monitoringLogEntity == null) {
            System.out.println("monitoringLogEntity");
        }
    }

    @Override
    public List<MonitoringLogDTO> getAllData() {
        return monitoringMapping.asMonitoringList(monitoringLogDAO.findAll());
    }

    @Override
    public void updateData(String id, MonitoringLogDTO monitoringLogDTO) {
        Optional<MonitoringLogEntity>monitoringLogEntity =monitoringLogDAO.findById(id);
        System.out.println(monitoringLogEntity.toString());//does not come to here the data which are sended by the controller
        if (!monitoringLogEntity.isPresent()) {
            System.out.println("monitoringLogentity is null");
        }else {
            monitoringLogEntity.get().setField(monitoringLogDTO.getFieldID());
            monitoringLogEntity.get().setLog_Date(monitoringLogDTO.getLog_Date());
            monitoringLogEntity.get().setObservation(monitoringLogDTO.getObservation());
            monitoringLogEntity.get().setObserved_image(monitoringLogDTO.getObserved_image());
            monitoringLogEntity.get().setCorpse(monitoringLogDTO.getCorpseID());
            monitoringLogEntity.get().setStaff(monitoringLogDTO.getStaffID());
        }
    }

    @Override
    public void deleteData(String id) {
        Optional<MonitoringLogEntity>monitoringLogEntity=monitoringLogDAO.findById(id);
        if (!monitoringLogEntity.isPresent()) {
            System.out.println("monitoringLogEntity is empty");
        }else {
            monitoringLogDAO.deleteById(id);
        }
    }


}
