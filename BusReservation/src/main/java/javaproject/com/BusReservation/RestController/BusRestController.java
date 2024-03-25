package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Bus;
import javaproject.com.BusReservation.Entity.User;
import javaproject.com.BusReservation.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BusRestController {

    private BusService busService;
    @Autowired
    public BusRestController(BusService buss){
        busService=buss;
    }

    @GetMapping("/buses")
    public List<Bus> findAll(){
        return busService.findAll();
    }
    @GetMapping("/buses/{id}")
    public Bus findById (@PathVariable int id){
        Bus agenies=busService.findById(id);
        if(agenies==null){
            throw  new RuntimeException("Bus not Found with id " + id);
        }
        return agenies;
    }

    @PostMapping("/buses")
    public Bus addbus(@RequestBody Bus bus){
        busService.save(bus);
        return bus;

    }





    @DeleteMapping("/bus/{id}")
    public String deleteBus(@PathVariable int id){
        Bus bus=busService.findById(id);
        if(bus==null){
            throw new RuntimeException("Busnot Found with id : " +id);
        }
        busService.deleteById(id);
        return "Delete Bus  with id" + id;
    }
}
