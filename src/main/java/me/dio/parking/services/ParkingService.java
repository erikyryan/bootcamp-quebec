package me.dio.parking.services;

import me.dio.parking.models.Parking;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String,Parking> parkingMap = new HashMap<>();

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public List<Parking> findAll(){
        Parking parking1 = new Parking();
        parking1.setId(getUUID());
        parking1.setColor("PRETO");
        parking1.setLicense("RSS-1111");
        parking1.setModel("GOL");
        parking1.setState("CE");

        Parking parking2 = new Parking();
        parking2.setId(getUUID());
        parking2.setColor("VERMELHO");
        parking2.setLicense("TTT-6666");
        parking2.setModel("CELTA");
        parking2.setState("AC");

        parkingMap.put(UUID.randomUUID().toString(),parking1);
        parkingMap.put(UUID.randomUUID().toString(),parking2);

        return parkingMap.values().stream().collect(Collectors.toList());
    }

}
