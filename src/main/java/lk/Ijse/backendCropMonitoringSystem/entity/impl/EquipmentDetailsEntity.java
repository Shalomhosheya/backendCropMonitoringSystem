package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipmentDetails")
public class EquipmentDetailsEntity {
    @Id
    private String equip_details;


}
