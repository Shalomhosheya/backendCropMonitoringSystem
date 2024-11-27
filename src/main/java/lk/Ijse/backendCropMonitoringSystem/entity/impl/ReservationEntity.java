package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.*;
import lk.Ijse.backendCropMonitoringSystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reservation")
public class ReservationEntity implements SuperEntity {
  @Id
  private String reservationID;

  private String date;
  private String response;
  private String reervationtype;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "staff",nullable = false)
  private StaffEntity staff;

  @ManyToOne
  @JoinColumn(name = "vehicle", nullable = false)
  private VehicleEntity vehicle;

}
