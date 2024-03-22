package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Bus;
import javaproject.com.BusReservation.Entity.History;
import javaproject.com.BusReservation.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryRestController {

    private HistoryService histroyService;
    @Autowired
    public HistoryRestController(HistoryService hs){
        histroyService=hs;
    }

    @GetMapping("/histories")
    public List<History> findAll(){
        return histroyService.findAll();
    }
    @GetMapping("/histories/{id}")
    public History findById (@PathVariable int id){
        History histories=histroyService.findById(id);
        if(histories==null){
            throw  new RuntimeException("Historynot Found with id " + id);
        }
        return histories;
    }

    @PostMapping("/history")
    public History updateBus(@RequestBody History history){
        histroyService.save(history);
        return history;

    }


    @DeleteMapping("/history/{id}")
    public String deleteBus(@PathVariable int id){
        History history=histroyService.findById(id);
        if(history==null){
            throw new RuntimeException("Historynot Found with id : " +id);
        }
        histroyService.deleteById(id);
        return "Delete History with id" + id;
    }
}
