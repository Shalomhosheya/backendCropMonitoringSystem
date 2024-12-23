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

    private String log_Date;
    private String observation;
    @Column(columnDefinition = "LONGTEXT")
    private String observed_image;

    @ManyToOne
    @JoinColumn(name = "staffID")
    private StaffEntity staff;

    @ManyToOne
    @JoinColumn(name = "fieldID")
    private FieldEntity field1;

    @ManyToOne
    @JoinColumn(name = "corpseID")
    private CorpseEntity crops;


}
