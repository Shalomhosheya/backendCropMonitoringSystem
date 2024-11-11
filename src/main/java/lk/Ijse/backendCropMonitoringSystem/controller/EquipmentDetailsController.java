package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dao.EquipmentDetailsDAO;
import lk.Ijse.backendCropMonitoringSystem.service.EquipmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/equip_details")
public class EquipmentDetailsController {
    @Autowired
    private EquipmentDetailsDAO equipmentDetailsDAO;

    @Autowired
    private EquipmentDetailsService equipmentDetailsService;
}
