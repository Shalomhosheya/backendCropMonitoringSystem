package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "monitoringLog")
public class MonitoringLogEntity {
    @Id
    private String monitoringL_id;
    @ManyToOne
    @JoinColumn(name = "staff")
    private StaffEntity staffEntity;
    @ManyToOne
    @JoinColumn(name = "field")
    private FieldEntity field;
    @ManyToOne
    @JoinColumn(name = "corpse")
    private CorpseEntity corpesEntity;

}
