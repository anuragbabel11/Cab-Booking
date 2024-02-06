package com.example.CabBooking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.CabBooking.Controllers.UserController;
import com.example.CabBooking.Dtos.DriverDto;
import com.example.CabBooking.Dtos.LocationDto;
import com.example.CabBooking.Dtos.UserDto;
import com.example.CabBooking.Services.DriverService;
import com.example.CabBooking.Services.RidesService;
import com.example.CabBooking.Services.UserService;
import org.springframework.boot.SpringApplication;

public class Demo {
    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);

    }
}