package Service;

import DAO.Bus_trackDao;
import Entity.Bus_track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Bus_trackService {

    private Bus_trackDao btdao;

    @Autowired
    public Bus_trackService(Bus_trackDao theBus_trackDao) {
        btdao = theBus_trackDao;
    }

    @Transactional
    public List<Bus_track> findAll() {
        return btdao.findAll();
    }

    @Transactional
    public Bus_track findById(int id) {
        return btdao.findById(id);
    }

    @Transactional
    public void save(Bus_track bt) {
        btdao.save(bt);
    }

    @Transactional
    public void deleteById(int id) {
        btdao.deleteById(id);
    }
}
