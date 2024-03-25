package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.User;
import javaproject.com.BusReservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;
    @Autowired
    public UserRestController(UserService buss){
        userService=buss;
    }

    @GetMapping("/useres")
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("/useres/{id}")
    public User findById (@PathVariable int id){
        User agenies=userService.findById(id);
        if(agenies==null){
            throw  new RuntimeException("Bus not Found with id " + id);
        }
        return agenies;
    }

    @PostMapping("/useres")
    public User adduser(@RequestBody User user){
        userService.save(user);
        return user;

    }





    @DeleteMapping("/user/{id}")
    public String deleteBus(@PathVariable int id){
        User user=userService.findById(id);
        if(user==null){
            throw new RuntimeException("Usernot Found with id : " +id);
        }
        userService.deleteById(id);
        return "Delete Bus  with id" + id;
    }
}
