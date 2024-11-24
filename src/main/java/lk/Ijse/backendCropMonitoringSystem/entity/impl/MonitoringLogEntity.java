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
    private StaffEntity Staff;
    @ManyToOne
    @JoinColumn(name = "fieldID")
    private FieldEntity field;
    @ManyToOne
    @JoinColumn(name = "corpseID")
    private CorpseEntity corpse;


    public void setField(String fieldID) {
    }

    public void setCorpse(String corpseID) {
    }

    public void setStaff(String staffID) {
    }
}
