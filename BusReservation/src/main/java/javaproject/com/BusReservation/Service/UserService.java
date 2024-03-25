package javaproject.com.BusReservation.Service;

import jakarta.transaction.Transactional;
import javaproject.com.BusReservation.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javaproject.com.BusReservation.DAO.UserDao;


import java.util.List;

@Service
public class UserService {
    private UserDao userDao;
    @Autowired
    public UserService(UserDao theuser){
        userDao=theuser;

    }
    @Transactional
    public List<User> findAll(){
        return userDao.findAll();
    }

    @Transactional
    public User findById(int id){
        return userDao.findById(id);
    }
    @Transactional
    public void save(User useres){

        userDao.save(useres);
    }

    @Transactional
    public void deleteById(int id){
        userDao.deleteById(id);
    }

}
