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
import java.util.Optional;

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

    @Override
    public void deleteData(String staffID) {
        Optional<StaffEntity>staffEntity=staffDAO.findById(staffID);
        if (!staffEntity.isPresent()) {
            System.out.println("null");
        }else {
            staffDAO.deleteById(staffID);
        }
    }

    @Override
    public void updateStaff(String staffId, StaffDTO staffDTO) {
        Optional<StaffEntity>staffEntity=staffDAO.findById(staffId);
        if (!staffEntity.isPresent()) {
            System.out.println("no content");
        }else {
            staffEntity.get().setFirstName(staffDTO.getFirstName());
            staffEntity.get().setLastName(staffDTO.getLastName());
            staffEntity.get().setDesignation(staffDTO.getDesignation());
            staffEntity.get().setGender(staffDTO.getGender());
            staffEntity.get().setDOB(staffDTO.getDOB());
            staffEntity.get().setJoinDate(staffDTO.getJoinDate());
            staffEntity.get().setAddress_1(staffDTO.getAddress_1());
            staffEntity.get().setAddress_2(staffDTO.getAddress_2());
            staffEntity.get().setAddress_3(staffDTO.getAddress_3());
            staffEntity.get().setAddress_4(staffDTO.getAddress_4());
            staffEntity.get().setAddress_5(staffDTO.getAddress_5());
            staffEntity.get().setContactNum(staffDTO.getContactNum());
            staffEntity.get().setEmail(staffDTO.getEmail());
            staffEntity.get().setRole(staffDTO.getRole());
            staffEntity.get().setField(staffDTO.getField());
        }
    }


}
