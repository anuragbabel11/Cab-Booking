package com.example.CabBooking;
import com.example.CabBooking.Dtos.DriverDto;
import com.example.CabBooking.Dtos.LocationDto;
import com.example.CabBooking.Dtos.UserDto;
import com.example.CabBooking.Services.DriverService;
import com.example.CabBooking.Services.RidesService;
import com.example.CabBooking.Services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
		UserService userService = new UserService();
		DriverService driverService = new DriverService();
		RidesService ridesService = new RidesService(driverService,userService);
		//all commands at one place
		System.out.println("Executing all test cases");
		userService.addUser(new UserDto("Abhishek", "M", 23));
		userService.addUser(new UserDto("Rahul", "M", 29));
		userService.addUser(new UserDto("Nandini", "F", 22));
		driverService.addDriver(new DriverDto("Driver1", "M", 22, "Swift, KA-01-12345", new LocationDto(10, 1),true));
		driverService.addDriver(new DriverDto("Driver2", "M", 29, "Swift, KA-01-12345", new LocationDto(11, 10),true));
		driverService.addDriver(new DriverDto("Driver3", "M", 24, "Swift, KA-01-12345", new LocationDto(5, 3),true));
		ridesService.findRide("Abhishek",new LocationDto(0, 0),
				new LocationDto(20, 1));
		ridesService.findRide("Rahul",new LocationDto(10, 0),
				new LocationDto(15, 3));
		ridesService.chooseRide("Rahul", "Driver1");
		//now Driver 1 is unavailable as it is chosen by Rahul
		//adding one more findRide call to demonstrate ChooseRide feature
		// Abhishek is now in the zone of Driver 1 but the driver is not available now

		ridesService.findRide("Abhishek",new LocationDto(10.3, 2),
				new LocationDto(20, 4));
		ridesService.findRide("Nandini",new LocationDto(15, 6),
				new LocationDto(20, 4));
	}

}
