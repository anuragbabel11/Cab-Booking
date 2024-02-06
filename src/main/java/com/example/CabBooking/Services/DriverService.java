package com.example.CabBooking.Services;
import com.example.CabBooking.Dtos.DriverDto;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
@Service
public class DriverService {
    private final Map<String, DriverDto> drivers  = new HashMap<>();
    public String addDriver(DriverDto driver){
        drivers.put(driver.getName(), new DriverDto(driver.getName(), driver.getGender(),
                driver.getAge(), driver.getVehicleDetails(), driver.getCurrentLocation(),driver.isAvailable()));
        System.out.println("driver Added");
        System.out.println(drivers);
        return "Driver has been added successfully ";
    }
    public Map<String, DriverDto> getAllDrivers(){
        return drivers;
    }
}
