package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.*;
import lk.Ijse.backendCropMonitoringSystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity implements SuperEntity {
    @Id
    private String equip_id;
    private String name;
    private String type;
    private String status;

    @OneToMany(mappedBy = "equipmentEntity",cascade = CascadeType.ALL)
    private List<EquipmentDetailsEntity>equipmentDetailsEntities;

}
