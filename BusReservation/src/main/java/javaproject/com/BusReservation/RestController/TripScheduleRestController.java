package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TripScheduleRestController {

    private BusService busService;
    @Autowired
    public TripScheduleRestController(BusService buss){
        busService=buss;
    }

    @GetMapping("/buses")
    public List<Bus> findAll(){
        return busService.findAll();
    }
    @GetMapping("/buses/{id}")
    public Bus findById (@PathVariable int id){
        Bus buses=busService.findById(id);
        if(buses==null){
            throw  new RuntimeException("Bus not Found with id " + id);
        }
        return buses;
    }

    @PostMapping("/bus")
    public Bus updateBus(@RequestBody Bus bus){
        busService.save(bus);
        return bus;

    }


    @DeleteMapping("/bus/{id}")
    public String deleteBus(@PathVariable int id){
        Bus bus=busService.findById(id);
        if(bus==null){
            throw new RuntimeException("Bus not Found with id : " +id);
        }
        busService.deleteById(id);
        return "Delete Bus  with id" + id;
    }
}
