package lk.Ijse.backendCropMonitoringSystem.controller;

import lk.Ijse.backendCropMonitoringSystem.dto.impl.ReservationDTO;
import lk.Ijse.backendCropMonitoringSystem.service.ReservationService;
import lk.Ijse.backendCropMonitoringSystem.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservstion")
@CrossOrigin
public class ReservationController {
 @Autowired
 private ReservationService reservationService;
 
 @PostMapping(value = "/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
 private ResponseEntity<Void>saveData(
         @RequestPart("staffId")String staffid,
         @RequestPart("vehicleId")String vehicleId,
         @RequestPart("date")String date,
         @RequestPart("response")String response,
         @RequestPart("reervationtype")String reervationtype
 ){
  String id = AppUtil.generateReservationID();
  ReservationDTO reservationDTO = new ReservationDTO();
  reservationDTO.setReservationID(id);
  reservationDTO.setStaffId(staffid);
  reservationDTO.setDate(date);
  reservationDTO.setResponse(response);
  reservationDTO.setVehicleId(vehicleId);
  reservationDTO.setReervationtype(reervationtype);
  reservationService.saveData(reservationDTO);
  return new ResponseEntity<>(HttpStatus.CREATED);
 }

 @GetMapping()
 private List<ReservationDTO>getAllData(){
  return reservationService.getAllData();
 }
 @PutMapping(value = "/{reservationID}",consumes = "application/json")
 private ResponseEntity<Void>updateData(@PathVariable("reservationID")String id,@RequestBody ReservationDTO reservationDTO
 ){
  reservationService.updateData(id,reservationDTO);
  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
 @DeleteMapping(value = "/{reservationID}")
 private ResponseEntity<Void>deleteData(@PathVariable("reservationID")String id){

  reservationService.deleteData(id);
  return new ResponseEntity<>(HttpStatus.ACCEPTED);
 }
}
