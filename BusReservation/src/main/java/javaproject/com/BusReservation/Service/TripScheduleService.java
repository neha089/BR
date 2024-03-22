package javaproject.com.BusReservation.Service;

import javaproject.com.BusReservation.DAO.TripScheduleDao;
import javaproject.com.BusReservation.Entity.Bus;
import jakarta.transaction.Transactional;
import javaproject.com.BusReservation.Entity.TripSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripScheduleService {
    private TripScheduleDao tripscheduleDao;
    @Autowired
    public TripScheduleService(TripScheduleDao thebus){
        tripscheduleDao=thebus;

    }
    @Transactional
    public List<TripSchedule> findAll(){
        return tripscheduleDao.findAll();
    }

    @Transactional
    public TripSchedule findById(int id){
        return tripscheduleDao.findById(id);
    }
    @Transactional
    public void save(TripSchedule ts){
        tripscheduleDao.save(ts);
    }

    @Transactional
    public void deleteById(int id){
        tripscheduleDao.deleteById(id);
    }

}
