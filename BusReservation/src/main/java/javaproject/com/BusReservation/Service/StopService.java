package javaproject.com.BusReservation.Service;

import javaproject.com.BusReservation.DAO.StopDao;
import javaproject.com.BusReservation.Entity.Bus;
import jakarta.transaction.Transactional;
import javaproject.com.BusReservation.Entity.Stop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopService {
    private StopDao stopDao;
    @Autowired
    public StopService(StopDao thestop){
        stopDao=thestop;

    }
    @Transactional
    public List<Stop> findAll(){
        return stopDao.findAll();
    }

    @Transactional
    public Stop findById(int id){
        return stopDao.findById(id);
    }
    @Transactional
    public void save(Stop stopes){
        stopDao.save(stopes);
    }

    @Transactional
    public void deleteById(int id){
        stopDao.deleteById(id);
    }

}
