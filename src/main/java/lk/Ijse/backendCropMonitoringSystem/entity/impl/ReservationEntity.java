package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.*;
import lk.Ijse.backendCropMonitoringSystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


  @ManyToOne()
  @JoinColumn(name = "staff",nullable = false)
  private StaffEntity staffEntity;

  @ManyToOne()
  @JoinColumn(name = "vehicle",nullable = false)
  private VehicleEntity vehicleEntity;



}