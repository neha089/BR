package javaproject.com.BusReservation.Service;

import javaproject.com.BusReservation.DAO.HistoryDao;
import jakarta.transaction.Transactional;
import javaproject.com.BusReservation.Entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    private HistoryDao historyDao;
    @Autowired
    public HistoryService(HistoryDao thebus){
        historyDao=thebus;

    }
    @Transactional
    public List<History> findAll(){
        return historyDao.findAll();
    }

    @Transactional
    public History findById(int id){
        return historyDao.findById(id);
    }
    @Transactional
    public void save(History bus){
        historyDao.save(bus);
    }

    @Transactional
    public void deleteById(int id){
        historyDao.deleteById(id);
    }

}

