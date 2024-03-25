package javaproject.com.BusReservation.Service;

import javaproject.com.BusReservation.DAO.RoleDao;
import jakarta.transaction.Transactional;
import javaproject.com.BusReservation.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleDao roleDao;
    @Autowired
    public RoleService(RoleDao theuser){
        roleDao=theuser;

    }
    @Transactional
    public List<Role> findAll(){
        return roleDao.findAll();
    }

    @Transactional
    public Role findById(int id){
        return roleDao.findById(id);
    }
    @Transactional
    public void save(Role rolees){

        roleDao.save(rolees);
    }

    @Transactional
    public void deleteById(int id){
        roleDao.deleteById(id);
    }

}
