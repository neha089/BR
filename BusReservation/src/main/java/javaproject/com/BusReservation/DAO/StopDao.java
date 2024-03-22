package javaproject.com.BusReservation.DAO;



import javaproject.com.BusReservation.Entity.Stop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StopDao {
    private EntityManager entityManager;
    @Autowired
    public StopDao(EntityManager newentitymanager){
        entityManager=newentitymanager;
    }

    public List<Stop> findAll(){

        TypedQuery<Stop> query=entityManager.createQuery("from Stop",Stop.class);
        List<Stop> stopes=query.getResultList();
        return stopes;
    }
    public Stop findById(int Id){
        Stop stopes=entityManager.find(Stop.class,Id);
        return stopes;
    }
    public void save (Stop stopes){
        Object savebus=entityManager.merge(stopes);
    }
    public void deleteById(int Id){
        Query query=entityManager.createQuery("delete from Stop where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}
