package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Bus;
import javaproject.com.BusReservation.Entity.TripSchedule;
import javaproject.com.BusReservation.Service.BusService;
import javaproject.com.BusReservation.Service.TripScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TripScheduleRestController {

    private TripScheduleService tripslService;
    @Autowired
    public TripScheduleRestController(TripScheduleService tripsches){
        tripslService=tripsches;
    }
    @GetMapping("/tripsch")
    public List<TripSchedule> findAll(){
        return tripslService.findAll();
    }
    @GetMapping("/tripsch/{id}")
    public TripSchedule findById (@PathVariable int id){
        TripSchedule tripsch=tripslService.findById(id);
        if(tripsch==null){
            throw  new RuntimeException("Bus not Found with id " + id);
        }
        return tripsch;
    }

    @PostMapping("/tripsl")
    public TripSchedule updateBus(@RequestBody TripSchedule tripsl){
        tripslService.save(tripsl);
        return tripsl;

    }


    @DeleteMapping("/tripsl/{id}")
    public String deleteBus(@PathVariable int id){
        TripSchedule tripsl=tripslService.findById(id);
        if(tripsl==null){
            throw new RuntimeException("Bus not Found with id : " +id);
        }
        tripslService.deleteById(id);
        return "Delete Bus  with id" + id;
    }
}
