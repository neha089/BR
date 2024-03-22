package javaproject.com.BusReservation.RestController;

import javaproject.com.BusReservation.Entity.User;
import javaproject.com.BusReservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/api")
public class UserRestController {

    private UserService btservice;
    @Autowired
    public UserRestController(UserService buss){
        btservice=buss;
    }

    @GetMapping("/user")
    public List<User> findAll(){
        return btservice.findAll();
    }
    @GetMapping("/user/{id}")
    public User findById (@PathVariable int id){
        User buses=btservice.findById(id);
        if(buses==null){
            throw  new RuntimeException("User not Found with id " + id);
        }
        return buses;
    }

    @PostMapping("/user")
    public User updateUser(@RequestBody User bus){
        btservice.save(bus);
        return bus;

    }
    @PutMapping("/user")
    public User updateusers(@RequestBody User Passanger){
        btservice.save(Passanger);
        return Passanger;
    }

    @DeleteMapping("/User/{id}")
    public String deleteUser(@PathVariable int id){
        User bus=btservice.findById(id);
        if(bus==null){
            throw new RuntimeException("User not Found with id : " +id);
        }
        btservice.deleteById(id);
        return "Delete User with id" + id;
    }
}