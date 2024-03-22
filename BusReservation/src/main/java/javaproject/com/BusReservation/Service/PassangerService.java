package javaproject.com.BusReservation.Service;

import javaproject.com.BusReservation.DAO.PassangerDao;
import javaproject.com.BusReservation.Entity.Passanger;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassangerService {
    private PassangerDao passangerDao;
    @Autowired
    public PassangerService(PassangerDao thePassanger){
        passangerDao=thePassanger;

    }
    @Transactional
    public List<Passanger> findAll(){
        return passangerDao.findAll();
    }

    @Transactional
    public Passanger findById(int id){
        return passangerDao.findById(id);
    }
    @Transactional
    public void save(Passanger Passanger){
        passangerDao.save(Passanger);
    }

    @Transactional
    public void deleteById(int id){
        passangerDao.deleteById(id);
    }

}


