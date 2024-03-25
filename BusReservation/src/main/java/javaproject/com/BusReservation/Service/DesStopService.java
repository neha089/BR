package javaproject.com.BusReservation.Service;

import jakarta.transaction.Transactional;
import javaproject.com.BusReservation.DAO.DesStopDao;
import javaproject.com.BusReservation.Entity.DesStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesStopService {
    private DesStopDao stopDao;
    @Autowired
    public DesStopService(DesStopDao thestop){
        stopDao=thestop;

    }
    @Transactional
    public List<DesStop> findAll(){
        return stopDao.findAll();
    }

    @Transactional
    public DesStop findById(int id){
        return stopDao.findById(id);
    }
    @Transactional
    public void save(DesStop stopes){

        stopDao.save(stopes);
    }

    @Transactional
    public void deleteById(int id){
        stopDao.deleteById(id);
    }

}
