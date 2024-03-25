package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Passanger;
import javaproject.com.BusReservation.Entity.Passanger;
import javaproject.com.BusReservation.Service.PassangerService;
import javaproject.com.BusReservation.Service.PassangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PassangerRestController {

    private PassangerService passangerService;
    @Autowired
    public PassangerRestController(PassangerService buss){
        passangerService=buss;
    }

    @GetMapping("/passangers")
    public List<Passanger> findAll(){
        return passangerService.findAll();
    }
    @GetMapping("/passangers/{id}")
    public Passanger findById (@PathVariable int id){
        Passanger agenies=passangerService.findById(id);
        if(agenies==null){
            throw  new RuntimeException("Passanger not Found with id " + id);
        }
        return agenies;
    }

    @PostMapping("/passanger")
    public Passanger addpassanger(@RequestBody Passanger passanger){
        passangerService.save(passanger);
        return passanger;

    }





    @DeleteMapping("/passanger/{id}")
    public String deletePassanger(@PathVariable int id){
        Passanger passanger=passangerService.findById(id);
        if(passanger==null){
            throw new RuntimeException("Passangernot Found with id : " +id);
        }
        passangerService.deleteById(id);
        return "Delete Passanger  with id" + id;
    }
}
