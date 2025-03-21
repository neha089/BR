package javaproject.com.BusReservation.DAO;



import javaproject.com.BusReservation.Entity.Agency;
import javaproject.com.BusReservation.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private EntityManager entityManager;
    @Autowired
    public UserDao(EntityManager newentitymanager){
        entityManager=newentitymanager;
    }

    public List<User> findAll(){

        TypedQuery<User> query=entityManager.createQuery("from User",User.class);
        List<User> agencyes=query.getResultList();
        return agencyes;
    }
    public User findById(int Id){
        User agencyes=entityManager.find(User.class,Id);
        return agencyes;
    }
    public void save (User agencyes){
        Object savebus=entityManager.merge(agencyes);
    }
    public void deleteById(int Id){
        Query query=entityManager.createQuery("delete from User where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}
