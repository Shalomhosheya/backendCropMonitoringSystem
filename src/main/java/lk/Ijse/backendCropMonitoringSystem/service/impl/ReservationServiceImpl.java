package lk.Ijse.backendCropMonitoringSystem.service.impl;

import jakarta.transaction.Transactional;
import lk.Ijse.backendCropMonitoringSystem.dao.ReservationDAO;
import lk.Ijse.backendCropMonitoringSystem.dto.impl.ReservationDTO;
import lk.Ijse.backendCropMonitoringSystem.entity.impl.ReservationEntity;
import lk.Ijse.backendCropMonitoringSystem.service.ReservationService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import lk.Ijse.backendCropMonitoringSystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
   @Autowired
   private ReservationDAO reservationDAO;

   @Autowired
   private Mapping reservationMapping;

    @Override
    public void saveData(ReservationDTO reservationDTO) {
         reservationDTO.setReservationID(AppUtil.generateReservationID());
        ReservationEntity reservationEntity =reservationDAO.save(reservationMapping.toReservationEntity(reservationDTO));
        if (reservationEntity == null) {
            System.out.println("reservationEntity is null");
        }
    }

    @Override
    public List<ReservationDTO> getAllData() {
       return reservationMapping.asReservationDTOList(reservationDAO.findAll());
    }

    @Override
    public void updateData(String id, ReservationDTO reservationDTO) {
        Optional<ReservationEntity>reservationEntity =reservationDAO.findById(id);
        if (!reservationEntity.isPresent()) {
            System.out.println("reservation is null");
        }else {
            ReservationEntity update = reservationMapping.toReservationEntity(reservationDTO);
            reservationEntity.get().setDate(update.getDate());
            reservationEntity.get().setStaff(update.getStaff());
            reservationEntity.get().setVehicle(update.getVehicle());
            reservationEntity.get().setResponse(update.getResponse());
            reservationEntity.get().setReervationtype(update.getReervationtype());

        }
    }

    @Override
    public void deleteData(String id) {
        Optional<ReservationEntity>reservationEntity =reservationDAO.findById(id);
        if (!reservationEntity.isPresent()) {
            System.out.println("reservationEntity is null");
        }else {
            reservationDAO.deleteById(id);
        }

    }
}
