package javaproject.com.BusReservation.Service;

import javaproject.com.BusReservation.DAO.TicketDao;
import javaproject.com.BusReservation.Entity.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private TicketDao TicketDao;
    @Autowired
    public TicketService(TicketDao theTicket){
        TicketDao=theTicket;

    }
    @Transactional
    public List<Ticket> findAll(){
        return TicketDao.findAll();
    }

    @Transactional
    public Ticket findById(int id){
        return TicketDao.findById(id);
    }
    @Transactional
    public void save(Ticket Ticket){
        TicketDao.save(Ticket);
    }

    @Transactional
    public void deleteById(int id){
        TicketDao.deleteById(id);
    }

}


