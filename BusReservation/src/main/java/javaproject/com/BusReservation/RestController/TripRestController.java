package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Trip;
import javaproject.com.BusReservation.Service.DesStopService;
import javaproject.com.BusReservation.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TripRestController {
    private TripService tpservice;

    private DesStopService stopService;
    @Autowired
    public TripRestController(TripService buss, DesStopService stop){

        tpservice=buss;
        stopService=stop;


    }

    @GetMapping("/trips_track")
    public List<Trip> findAll(){
        return tpservice.findAll();
    }
    @GetMapping("/trips_track/{id}")
    public Trip findById (@PathVariable int id){
        Trip trips=tpservice.findById(id);
        if(trips==null){
            throw  new RuntimeException("Tripnot Found with id " + id);
        }
        return trips;
    }

    @PostMapping("/trip_track")
    public Trip updateBustrack(@RequestBody Trip trip){
//        Stop destinationStop = stopService.findById(trip.getDestStop().getS_id());
//        // Set the fetched destination Stop in the Trip entity
//        trip.setDestStop(destinationStop);

        // Save the Trip entity
        tpservice.save(trip);

        return trip;

    }
    @PutMapping("/trip_track")
    public Trip updatePassangers(@RequestBody Trip Passanger){
        tpservice.save(Passanger);
        return Passanger;
    }

    @DeleteMapping("/trip_track/{id}")
    public String deleteTrip(@PathVariable int id){
        Trip trip=tpservice.findById(id);
        if(trip==null){
            throw new RuntimeException("Trip not Found with id : " +id);
        }
        tpservice.deleteById(id);
        return "Delete Trip with id" + id;
    }
}
