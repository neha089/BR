package javaproject.com.BusReservation.Service;

import javaproject.com.BusReservation.DAO.BusDao;
import javaproject.com.BusReservation.Entity.Bus;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    private BusDao busDao;
    @Autowired
    public BusService(BusDao thebus){
        busDao=thebus;

    }
    @Transactional
    public List<Bus> findAll(){
        return busDao.findAll();
    }

    @Transactional
    public Bus findById(int id){
        return busDao.findById(id);
    }
    @Transactional
    public void save(Bus bus){
         busDao.save(bus);
    }

    @Transactional
    public void deleteById(int id){
         busDao.deleteById(id);
    }

}
