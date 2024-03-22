package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Bus;
import javaproject.com.BusReservation.Entity.Trip;
import javaproject.com.BusReservation.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TripRestController {
    private TripService tpservice;
    @Autowired
    public TripRestController(TripService buss){
        tpservice=buss;
    }

    @GetMapping("/buses_track")
    public List<Trip> findAll(){
        return tpservice.findAll();
    }
    @GetMapping("/buses_track/{id}")
    public Trip findById (@PathVariable int id){
        Trip buses=tpservice.findById(id);
        if(buses==null){
            throw  new RuntimeException("Tripnot Found with id " + id);
        }
        return buses;
    }

    @PostMapping("/bus_track")
    public Trip updateBustrack(@RequestBody Trip bus){
        tpservice.save(bus);
        return bus;

    }
    @PutMapping("/bus_track")
    public Trip updatePassangers(@RequestBody Trip Passanger){
        tpservice.save(Passanger);
        return Passanger;
    }

    @DeleteMapping("/bus_track/{id}")
    public String deleteTrip(@PathVariable int id){
        Trip bus=tpservice.findById(id);
        if(bus==null){
            throw new RuntimeException("Trip not Found with id : " +id);
        }
        tpservice.deleteById(id);
        return "Delete Trip with id" + id;
    }
}
