package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.SouStop;
import javaproject.com.BusReservation.Service.SouStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SouStopRestController {

    private SouStopService soustopService;
    @Autowired
    public SouStopRestController(SouStopService buss){
        soustopService=buss;
    }

    @GetMapping("/sources")
    public List<SouStop> findAll(){
        return soustopService.findAll();
    }
    @GetMapping("/soustopes/{id}")
    public SouStop findById (@PathVariable int id){
        SouStop agenies=soustopService.findById(id);
        if(agenies==null){
            throw  new RuntimeException("Bus not Found with id " + id);
        }
        return agenies;
    }

    @PostMapping("/soustopes")
    public SouStop addsoustop(@RequestBody SouStop soustop){
        soustopService.save(soustop);
        return soustop;

    }
    @DeleteMapping("/soustop/{id}")
    public String deleteBus(@PathVariable int id){
        SouStop soustop=soustopService.findById(id);
        if(soustop==null){
            throw new RuntimeException("SouStopnot Found with id : " +id);
        }
        soustopService.deleteById(id);
        return "Delete Bus  with id" + id;
    }
}
