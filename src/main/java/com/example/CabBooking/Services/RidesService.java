package com.example.CabBooking.Services;
import com.example.CabBooking.Dtos.DriverDto;
import com.example.CabBooking.Dtos.LocationDto;
import com.example.CabBooking.Dtos.UserDto;
import com.example.CabBooking.Exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RidesService {
    private final UserService userService;
    private DriverService driverService;
    private static List<DriverDto> availableDrivers = new ArrayList<>();

    private Map<String, DriverDto> drivers;
    private Map<String, UserDto> users;
    public RidesService(DriverService driverService, UserService userService) {
        this.driverService = driverService;
        this.userService = userService;
        users = userService.getAllUsers();
        drivers = driverService.getAllDrivers();
    }

    public List<DriverDto> findRide(String username, LocationDto source, LocationDto destination){
        availableDrivers.clear();
        if (!users.containsKey(username)) {
            throw new UserNotFoundException("User not found");
        }
        for(Map.Entry<String, DriverDto> entry : drivers.entrySet()){
            if(isWithinFiveUnits(entry.getValue().getCurrentLocation(), source) && entry.getValue().isAvailable()){
                availableDrivers.add(entry.getValue());
            }
        }
        if (availableDrivers.isEmpty()) {
            System.out.println("No ride found for " + username +":"+source);
            //throw new RideNotFoundException("No ride found");
        }
        else{
            System.out.println("Rides Found for "+ username +" Available Driver :"+availableDrivers);
        }

        return availableDrivers;
    }
    private boolean isWithinFiveUnits(LocationDto currentLocation , LocationDto source){
        double distance = Math.sqrt(Math.pow((currentLocation.getLatitude() - source.getLatitude()), 2) + Math.pow((currentLocation.getLongitude() - source.getLongitude()), 2));
        return distance <=5;
    }

    //Assuming chooseRide functionality is called after a successful findRide call
    public String chooseRide(String username, String driverName){
        if (!users.containsKey(username)) {
            throw new UserNotFoundException("User not found");
        }
        //could be optimized using hashTables
        for(DriverDto driver : availableDrivers){
            if(driver.getName().equals(driverName)){
                System.out.println("Ride Chosen by User " + username +" with Driver - "+driverName);
                driver.setAvailable(false);
                return driverName;
            }
        }
        if(!availableDrivers.isEmpty()){
            System.out.println("Driver is not available");
        }
        return "No rides found";
    }
}