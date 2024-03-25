package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.DesStop;
import javaproject.com.BusReservation.Entity.User;
import javaproject.com.BusReservation.Service.DesStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DesStopRestController {
    private DesStopService desstopService;
    @Autowired
    public DesStopRestController(DesStopService buss){
        desstopService=buss;
    }
    @GetMapping("/desstopes")
    public List<DesStop> findAll(){
        return desstopService.findAll();
    }
    @GetMapping("/desstopes/{id}")
    public DesStop findById (@PathVariable int id){
        DesStop agenies=desstopService.findById(id);
        if(agenies==null){
            throw  new RuntimeException("Bus not Found with id " + id);
        }
        return agenies;
    }
    @PostMapping("/desstopes")
    public DesStop adddesstop(@RequestBody DesStop desstop){
        desstopService.save(desstop);
        return desstop;

    }
    @DeleteMapping("/desstop/{id}")
    public String deleteBus(@PathVariable int id){
        DesStop desstop=desstopService.findById(id);
        if(desstop==null){
            throw new RuntimeException("DesStopnot Found with id : " +id);
        }
        desstopService.deleteById(id);
        return "Delete Bus  with id" + id;
    }
}
