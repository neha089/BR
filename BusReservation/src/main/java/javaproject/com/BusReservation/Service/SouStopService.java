package javaproject.com.BusReservation.Service;


import javaproject.com.BusReservation.DAO.SouStopDao;
import javaproject.com.BusReservation.Entity.Bus;
import jakarta.transaction.Transactional;
import javaproject.com.BusReservation.Entity.SouStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SouStopService {
    private SouStopDao busDao;
    @Autowired
    public SouStopService(SouStopDao thebus){
        busDao=thebus;

    }


    @Transactional
    public List<SouStop> findAll(){
        return busDao.findAll();
    }

    @Transactional
    public SouStop findById(int id){
        return busDao.findById(id);
    }
    @Transactional
    public void save(SouStop bus){
        busDao.save(bus);
    }

    @Transactional
    public void deleteById(int id){
        busDao.deleteById(id);
    }

}


