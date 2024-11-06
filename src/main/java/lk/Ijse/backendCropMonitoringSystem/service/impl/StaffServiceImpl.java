package lk.Ijse.backendCropMonitoringSystem.service.impl;

import jakarta.transaction.Transactional;
import lk.Ijse.backendCropMonitoringSystem.dao.StaffDAO;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.StaffDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.StaffEntity;
import lk.Ijse.backendCropMonitoringSystem.service.StaffService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    private Mapping staffMapping;

    @Autowired
    private StaffDAO staffDAO;
    @Override
    public void savestaff(StaffDTO staffDTO) {
      staffDTO.setStaffID(AppUtil.generateStaffID());
        StaffEntity savefile=staffDAO.save(staffMapping.toStaffEntity(staffDTO));
        if (savefile==null){
            System.out.println("savestaff entity is null");
        }
    }

    @Override
    public List<StaffDTO> getAllStaffFields() {
        return staffMapping.asStaffDTOList(staffDAO.findAll());
    }


}
