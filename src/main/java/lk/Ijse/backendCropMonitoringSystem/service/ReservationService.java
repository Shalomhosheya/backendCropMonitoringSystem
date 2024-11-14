package lk.Ijse.backendCropMonitoringSystem.service;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.ReservationDTO;

import java.util.List;

public interface ReservationService{
    void saveData(ReservationDTO reservationDTO);

    List<ReservationDTO> getAllData();

    void updateData(String id, ReservationDTO reservationDTO);

    void deleteData(String id);
}
