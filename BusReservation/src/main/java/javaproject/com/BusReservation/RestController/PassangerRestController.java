package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Passanger;
import javaproject.com.BusReservation.Service.PassangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/api")

public class PassangerRestController {
    private PassangerService pservice;

    @Autowired
    public PassangerRestController(PassangerService buss) {
        pservice = buss;
    }

    @GetMapping("/Passangeres")
    public List<Passanger> findAll() {
        return pservice.findAll();
    }

    @GetMapping("/Passangeres/{id}")
    public Passanger findById(@PathVariable int id) {
        Passanger Passangeres = pservice.findById(id);
        if (Passangeres == null) {
            throw new RuntimeException("Passanger not Found with id " + id);
        }
        return Passangeres;
    }

    @PostMapping("/Passanger")
    public Passanger updatePassanger(@RequestBody Passanger Passanger) {
        pservice.save(Passanger);
        return Passanger;

    }

    @PutMapping("/Passanger")
    public Passanger updatePassangers(@RequestBody Passanger Passanger) {
        pservice.save(Passanger);
        return Passanger;
    }

    @DeleteMapping("/Passanger/{id}")
    public String deletePassanger(@PathVariable int id) {
        Passanger Passanger = pservice.findById(id);
        if (Passanger == null) {
            throw new RuntimeException("Passanger not Found with id : " + id);
        }
        pservice.deleteById(id);
        return "Delete Passanger  with id" + id;
    }
}
