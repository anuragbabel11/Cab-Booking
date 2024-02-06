package com.example.CabBooking.Controllers;
import com.example.CabBooking.Dtos.DriverDto;
import com.example.CabBooking.Services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @PostMapping("/add")
    public String addUser(@RequestBody DriverDto driverDto){

        try{
            String result = driverService.addDriver(driverDto);
            return result;
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getDrivers")
    public Map<String, DriverDto> getAllDrivers(){
        return driverService.getAllDrivers();
    }


}

