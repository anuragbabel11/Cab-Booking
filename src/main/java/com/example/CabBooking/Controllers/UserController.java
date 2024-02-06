package com.example.CabBooking.Controllers;
import com.example.CabBooking.Dtos.UserDto;
import com.example.CabBooking.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public String addUser(@RequestBody UserDto userDto){
        try{
            String result = userService.addUser(userDto);
            return result;
        }catch (Exception e){
            return e.getMessage();
        }
    }
    @GetMapping("/getUsers")
    public Map<String, UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
}
