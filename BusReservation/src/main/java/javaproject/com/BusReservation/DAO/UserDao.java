package javaproject.com.BusReservation.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import javaproject.com.BusReservation.Entity.User;
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
        List<User> users=query.getResultList();
        return users;
    }
    public User findById(int Id){
        User users=entityManager.find(User.class,Id);
        return users;
    }
    public void save (User useres){
        Object saveuser=entityManager.merge(useres);
    }
    public void deleteById(int Id){
        Query query=entityManager.createQuery("delete from User where id=: userid");

        query.setParameter("userid",Id);
        query.executeUpdate();
    }

}
