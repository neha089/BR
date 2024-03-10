package RestController;

import Entity.Ticket;
import Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/Api")
public class TicketRestController {

    private TicketService tservice;
    @Autowired
    public TicketRestController (TicketService buss){
        tservice=buss;
    }

    @GetMapping("/Ticketes")
    public List<Ticket> findAll(){
        return tservice.findAll();
    }
    @GetMapping("/Ticketes/{id}")
    public Ticket findById (@PathVariable int id){
        Ticket Ticketes=tservice.findById(id);
        if(Ticketes==null){
            throw  new RuntimeException("Ticket not Found with id " + id);
        }
        return Ticketes;
    }

    @PostMapping("/Ticket")
    public Ticket updateTicket(@RequestBody Ticket Ticket){
        tservice.save(Ticket);
        return Ticket;

    }

    @PutMapping("/Ticket")
    public Ticket updateTickets(@RequestBody Ticket Ticket){
        tservice.save(Ticket);
        return Ticket;
    }

    @DeleteMapping("/Ticket/{id}")
    public String deleteTicket(@PathVariable int id){
        Ticket Ticket=tservice.findById(id);
        if(Ticket==null){
            throw new RuntimeException("Ticket not Found with id : " +id);
        }
        tservice.deleteById(id);
        return "Delete Ticket  with id" + id;
    }
}
