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
@Table(name = "equipmentDetails")
public class EquipmentDetailsEntity implements SuperEntity {
    @Id
    private String equip_detailsID;
    private String date;
    private String resone;

    @ManyToOne
    @JoinColumn(name = "equip_id",nullable = false)
    private EquipmentEntity equipment;

    @ManyToOne
    @JoinColumn(name = "staffID",nullable = false)
    private StaffEntity Staff;

    @ManyToOne
    @JoinColumn(name = "fieldID",nullable = false)
    private FieldEntity field;

}
