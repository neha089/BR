package RestController;
import Service.Bus_trackService;
import Entity.Bus_track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api")
public class Bus_trackController {
    private Bus_trackService btservice;
    @Autowired
    public Bus_trackController(Bus_trackService buss){
        btservice=buss;
    }

    @GetMapping("/buses")
    public List<Bus_track> findAll(){
        return btservice.findAll();
    }
    @GetMapping("/buses/{id}")
    public Bus_track findById (@PathVariable int id){
        Bus_track buses=btservice.findById(id);
        if(buses==null){
            throw  new RuntimeException("Bus_tracknot Found with id " + id);
        }
        return buses;
    }

    @PostMapping("/bus")
    public Bus_track updateBustrack(@RequestBody Bus_track bus){
        btservice.save(bus);
        return bus;

    }
    @PutMapping("/Passanger")
    public Bus_track updatePassangers(@RequestBody Bus_track Passanger){
        btservice.save(Passanger);
        return Passanger;
    }

    @DeleteMapping("/bus/{id}")
    public String deleteBus_track(@PathVariable int id){
        Bus_track bus=btservice.findById(id);
        if(bus==null){
            throw new RuntimeException("Bus_track not Found with id : " +id);
        }
        btservice.deleteById(id);
        return "Delete Bus_track with id" + id;
    }
}
