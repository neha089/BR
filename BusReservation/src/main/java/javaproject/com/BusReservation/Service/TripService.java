package javaproject.com.BusReservation.Service;

import javaproject.com.BusReservation.DAO.TripDao;
import javaproject.com.BusReservation.Entity.Bus;
import jakarta.transaction.Transactional;
import javaproject.com.BusReservation.Entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private TripDao tripDao;
    @Autowired
    public TripService(TripDao thebus){
        tripDao=thebus;

    }
    @Transactional
    public List<Trip> findAll(){
        return tripDao.findAll();
    }

    @Transactional
    public Trip findById(int id){
        return tripDao.findById(id);
    }
    @Transactional
    public void save(Trip t){
        tripDao.save(t);
    }

    @Transactional
    public void deleteById(int id){
        tripDao.deleteById(id);
    }

}
