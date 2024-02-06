package com.example.CabBooking.Controllers;
import com.example.CabBooking.Dtos.DriverDto;
import com.example.CabBooking.Dtos.LocationDto;
import com.example.CabBooking.Services.RidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ride")
public class RidesController {

    @Autowired
    private RidesService ridesService;

    @GetMapping("/findRide")
    public List<DriverDto> findRide(@RequestParam String username, @RequestParam double sourceLatitude, @RequestParam double sourceLongitude, @RequestParam double destinationLatitude, @RequestParam double destinationLongitude) {
        LocationDto source = new LocationDto(sourceLatitude, sourceLongitude);
        LocationDto destination = new LocationDto(destinationLatitude, destinationLongitude);
        return ridesService.findRide(username, source, destination);
    }
    @PostMapping("/chooseRide")
    public String chooseRide(@RequestParam String username, @RequestParam String driverName) {
        return ridesService.chooseRide(username, driverName);
    }
}
