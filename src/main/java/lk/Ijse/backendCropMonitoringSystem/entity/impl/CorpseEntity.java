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
@Table(name = "crops")
public class CorpseEntity implements SuperEntity {
    @Id
    private String corpseID;

    private String common_name;
    private String crop_scientific_name;

    @Column(columnDefinition = "LONGTEXT")
    private String crop_image;

    private String category;
    private String crop_season;


    @OneToMany(mappedBy = "crops")
    private List<MonitoringLogEntity>monitoringLogEntities2;
}
