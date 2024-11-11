package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.Ijse.backendCropMonitoringSystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "corpseEntity")
public class CorpseEntity implements SuperEntity {
    @Id
    private String corpseID;

    @OneToMany(mappedBy = "corpesEntity")
    private List<MonitoringLogEntity>monitoringLogEntities2;
}
