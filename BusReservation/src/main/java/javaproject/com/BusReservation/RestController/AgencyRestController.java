package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Agency;
import javaproject.com.BusReservation.Entity.Bus;
import javaproject.com.BusReservation.Service.AgencyService;
import javaproject.com.BusReservation.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AgencyRestController {

    private AgencyService agencyService;
    @Autowired
    public AgencyRestController(AgencyService buss){
        agencyService=buss;
    }

    @GetMapping("/agenies")
    public List<Agency> findAll(){
        return agencyService.findAll();
    }
    @GetMapping("/agenies/{id}")
    public Agency findById (@PathVariable int id){
        Agency agenies=agencyService.findById(id);
        if(agenies==null){
            throw  new RuntimeException("Bus not Found with id " + id);
        }
        return agenies;
    }

    @PostMapping("/agency")
    public Agency updateBus(@RequestBody Agency agency){
        agencyService.save(agency);
        return agency;

    }


    @DeleteMapping("/agency/{id}")
    public String deleteBus(@PathVariable int id){
        Agency agency=agencyService.findById(id);
        if(agency==null){
            throw new RuntimeException("Agencynot Found with id : " +id);
        }
        agencyService.deleteById(id);
        return "Delete Bus  with id" + id;
    }
}
