package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Agency;
import javaproject.com.BusReservation.Entity.Ticket;
import javaproject.com.BusReservation.Service.TicketService;
import javaproject.com.BusReservation.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketRestController {

    private TicketService ticketService;
    @Autowired
    public TicketRestController(TicketService buss){
        ticketService=buss;
    }

    @GetMapping("/tickets")
    public List<Ticket> findAll(){
        return ticketService.findAll();
    }
    @GetMapping("/tickets/{id}")
    public Ticket findById (@PathVariable int id){
        Ticket tickets=ticketService.findById(id);
        if(tickets==null){
            throw  new RuntimeException("Bus not Found with id " + id);
        }
        return tickets;
    }

    @PostMapping("/ticket")
    public Ticket addticket(@RequestBody Ticket ticket){
        ticketService.save(ticket);
        return ticket;

    }





    @DeleteMapping("/ticket/{id}")
    public String deleteBus(@PathVariable int id){
        Ticket ticket=ticketService.findById(id);
        if(ticket==null){
            throw new RuntimeException("Ticketnot Found with id : " +id);
        }
        ticketService.deleteById(id);
        return "Delete Bus  with id" + id;
    }
}
