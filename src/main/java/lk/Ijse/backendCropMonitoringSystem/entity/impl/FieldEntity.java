package lk.Ijse.backendCropMonitoringSystem.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.Ijse.backendCropMonitoringSystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
