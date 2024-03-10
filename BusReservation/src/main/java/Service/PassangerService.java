package Service;

import DAO.PassangerDao;
import Entity.Passanger;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassangerService {
    private DAO.PassangerDao PassangerDao;
    @Autowired
    public PassangerService(PassangerDao thePassanger){
        PassangerDao=thePassanger;

    }
    @Transactional
    public List<Passanger> findAll(){
        return PassangerDao.findAll();
    }

    @Transactional
    public Passanger findById(int id){
        return PassangerDao.findById(id);
    }
    @Transactional
    public void save(Passanger Passanger){
        PassangerDao.save(Passanger);
    }

    @Transactional
    public void deleteById(int id){
        PassangerDao.deleteById(id);
    }

}


