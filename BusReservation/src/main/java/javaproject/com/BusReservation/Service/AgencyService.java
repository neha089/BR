package javaproject.com.BusReservation.Service;

import javaproject.com.BusReservation.DAO.AgencyDao;
import javaproject.com.BusReservation.Entity.Agency;
import jakarta.transaction.Transactional;
import javaproject.com.BusReservation.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    private AgencyDao agencyDao;
    @Autowired
    public AgencyService(AgencyDao theuser){
        agencyDao=theuser;

    }
    @Transactional
    public List<Agency> findAll(){
        return agencyDao.findAll();
    }

    @Transactional
    public Agency findById(int id){
        return agencyDao.findById(id);
    }
    @Transactional
    public void save(Agency agencyes){

        agencyDao.save(agencyes);
    }

    @Transactional
    public void deleteById(int id){
        agencyDao.deleteById(id);
    }

}
