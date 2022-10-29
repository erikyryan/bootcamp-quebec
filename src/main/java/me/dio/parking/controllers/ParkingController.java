package me.dio.parking.controllers;

import me.dio.parking.controllers.mappers.ParkingMapper;
import me.dio.parking.models.Parking;
import me.dio.parking.models.dto.ParkingDTO;
import me.dio.parking.services.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }


    @GetMapping
    public List<ParkingDTO> findAll(){
        List<Parking> parkings =  parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkings);
        return result;
    }

}
