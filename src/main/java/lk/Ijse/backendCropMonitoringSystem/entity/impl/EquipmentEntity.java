package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity {
    @Id
    private String equip_id;
    private String name;
    private String type;
    private String status;
    @OneToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staffID")
    private StaffEntity staff;

    @OneToOne
    @JoinColumn(name = "field_ID",referencedColumnName = "fieldID")
    private FieldEntity field;

}