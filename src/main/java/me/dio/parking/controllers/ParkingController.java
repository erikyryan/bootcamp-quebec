package me.dio.parking.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.dio.parking.controllers.mappers.ParkingMapper;
import me.dio.parking.exception.ParkingNotFoundException;
import me.dio.parking.models.Parking;
import me.dio.parking.models.dto.ParkingCreateDTO;
import me.dio.parking.models.dto.ParkingDTO;
import me.dio.parking.services.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    private final ParkingService parkingService;

    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }


    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll(){
        List<Parking> parkings =  parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkings);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find by id a parking")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
        Parking parking =  parkingService.findById(id);
        if(parking == null){
            throw new ParkingNotFoundException(id);
        }
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation("Create Parking")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingDTO){
        Parking parkingCreate = parkingMapper.toParkingCreate(parkingDTO);
        Parking parking =  parkingService.create(parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Parking")
    public ResponseEntity<ParkingDTO> delete(@PathVariable String id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Parking")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO parkingDTO){
        Parking parkingCreate = parkingMapper.toParkingCreate(parkingDTO);
        Parking parking =  parkingService.update(id,parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

}
