package lk.Ijse.backendCropMonitoringSystem.util;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.*;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper mapper;

    public FieldEntity toFieldEntity(FieldDTO fieldDTO) {
        return mapper.map(fieldDTO,FieldEntity.class);
     }
     public StaffEntity toStaffEntity(StaffDTO staffDTO){
        return mapper.map(staffDTO,StaffEntity.class);
     }

     public VehicleEntity toVehicleEntity(VehicleDTO vehicleDTO){
        return mapper.map(vehicleDTO,VehicleEntity.class);
     }

     public EquipmentDetailsEntity toEquipmentdetailEntity(EquipmentDetailsDto equipmentDetailsDto){
        return mapper.map(equipmentDetailsDto,EquipmentDetailsEntity.class);
     }
    public EquipmentEntity toEquipEntity(EquipmentDTO equipmentDTO) {
        return mapper.map(equipmentDTO, EquipmentEntity.class);
    }
    public List<FieldDTO> asFieldDTOList(List<FieldEntity> fieldEntities) {
      return mapper.map(fieldEntities,new TypeToken<List<FieldDTO>>(){}.getType());
     }

     public List<StaffDTO>asStaffDTOList(List<StaffEntity>staffEntities){
        return mapper.map(staffEntities,new TypeToken<List<StaffDTO>>(){}.getType());
     }

     public List<VehicleDTO>asVehicleDTOList(List<VehicleEntity>vehicleEntities){
        return mapper.map(vehicleEntities,new TypeToken<List<VehicleDTO>>(){}.getType());
     }

    public List<EquipmentDTO>asEquipDtoList(List<EquipmentDetailsEntity>equipmentDetailsEntities){
        return  mapper.map(equipmentDetailsEntities,new TypeToken<List<EquipmentDetailsDto>>(){}.getType());
    }

    public List<EquipmentDTO> asEquipDTOList(List<EquipmentEntity>equipmentEntities) {
        return mapper.map(equipmentEntities,new TypeToken<List<EquipmentDTO>>(){}.getType());
    }
}
