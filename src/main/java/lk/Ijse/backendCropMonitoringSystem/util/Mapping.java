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
     public ReservationEntity toReservationEntity(ReservationDTO reservationDTO){
        return mapper.map(reservationDTO,ReservationEntity.class);
     }
     public MonitoringLogEntity tomonitoringLogEntity(MonitoringLogDTO monitoringLogDTO){
        return mapper.map(monitoringLogDTO,MonitoringLogEntity.class);
     }

     public CorpseEntity toCorpseEntity(CorpseDTO corpseDTO){
        return mapper.map(corpseDTO,CorpseEntity.class);
     }
     public EquipmentDetailsEntity toEquipmentdetailEntity(EquipmentDetailsDto equipmentDetailsDto){
        return mapper.map(equipmentDetailsDto,EquipmentDetailsEntity.class);
     }
    public EquipmentEntity toEquipEntity(EquipmentDTO equipmentDTO) {
        return mapper.map(equipmentDTO, EquipmentEntity.class);
    }
    public ReservationEntity toreservationEntity(ReservationDTO reservationDTO) {
        return mapper.map(reservationDTO,ReservationEntity.class);
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


    public List<EquipmentDTO> asEquipDTOList(List<EquipmentEntity>equipmentEntities) {
        return mapper.map(equipmentEntities,new TypeToken<List<EquipmentDTO>>(){}.getType());
    }

    public List<CorpseDTO> asCropsList(List<CorpseEntity>corpseEntities) {
        return mapper.map(corpseEntities,new TypeToken<List<CorpseDTO>>(){}.getType());
    }

    public List<MonitoringLogDTO> asMonitoringList(List<MonitoringLogEntity> monitoringLogEntities) {
        return mapper.map(monitoringLogEntities,new TypeToken<List<MonitoringLogDTO>>(){}.getType());
    }

    public List<EquipmentDetailsDto> asEquipDetailDtoList(List<EquipmentDetailsEntity> equipmentDetailsEntities) {
       return mapper.map(equipmentDetailsEntities,new TypeToken<List<EquipmentDetailsDto>>(){}.getType());
    }

    public List<ReservationDTO> asReservationDTOList(List<ReservationEntity> reservationEntities) {
        return mapper.map(reservationEntities, new TypeToken<List<ReservationDTO>>(){}.getType());
    }


}
