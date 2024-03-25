package javaproject.com.BusReservation.DAO;



import javaproject.com.BusReservation.Entity.Role;
import javaproject.com.BusReservation.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDao {
    private EntityManager entityManager;
    @Autowired
    public RoleDao(EntityManager newentitymanager){
        entityManager=newentitymanager;
    }

    public List<Role> findAll(){

        TypedQuery<Role> query=entityManager.createQuery("from Role",Role.class);
        List<Role> rolees=query.getResultList();
        return rolees;
    }
    public Role findById(int Id){
        Role rolees=entityManager.find(Role.class,Id);
        return rolees;
    }
    public void save (Role rolees){
        Object savebus=entityManager.merge(rolees);
    }
    public void deleteById(int Id){
        Query query=entityManager.createQuery("delete from Role where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}
