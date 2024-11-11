package lk.Ijse.backendCropMonitoringSystem.dto.impl;

import lk.Ijse.backendCropMonitoringSystem.dto.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO implements ReservationStatus {
  private String reservationID;
  private String staffId;
  private String vehicleId;
  private String date;
  private String response;
  private String reervationtype;

}
