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
@Table(name = "equipment")
public class EquipmentEntity implements SuperEntity {
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

    public void setStaff(String staffID) {
    }

    public void setField(String fieldID) {
    }
}
