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
@Table(name = "field")
public class FieldEntity implements SuperEntity {
    @Id
    private String fieldID;
    private String fieldName;
    private String fieldLocation;
    private String fieldSize;
    private String staff;

    @Column(columnDefinition = "LONGTEXT")
    private String picture;

    @Column(columnDefinition = "LONGTEXT")
    private String picture2;

    @OneToMany(mappedBy = "field",cascade = CascadeType.ALL)
    private List<EquipmentDetailsEntity>equipmentDetailsEntities;

    @OneToMany(mappedBy = "field1",cascade = CascadeType.ALL)
    private List<MonitoringLogEntity>monitoringLogEntities;
}
