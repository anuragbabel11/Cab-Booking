package com.example.CabBooking.Services;
import com.example.CabBooking.Dtos.UserDto;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Map<String, UserDto> users = new HashMap<>();
    public String addUser(UserDto user){
       users.put(user.getName(), new UserDto(user.getName(), user.getGender(), user.getAge()));
       System.out.println("user Added");
        System.out.println(users);
        return "User has been added successfully ";
    }
    public Map<String, UserDto> getAllUsers(){
        return users;
    }
}
