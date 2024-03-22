package javaproject.com.BusReservation.DAO;

import javaproject.com.BusReservation.Entity.Trip;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TripDao {
    private static EntityManager entityManager;
    @Autowired
    public TripDao(EntityManager newentitymanager){
        entityManager=newentitymanager;
    }

    public List<Trip> findAll(){

        TypedQuery<Trip> query=entityManager.createQuery("from Trip", Trip.class);
        List<Trip> trips=query.getResultList();
        return trips;
    }
    public Trip findById(int Id){
        Trip trips=entityManager.find(Trip.class,Id);
        return trips;
    }
    public void save (Trip trips){
        Object savebus=entityManager.merge(trips);
    }
    public static void deleteById(int Id){
        Query query=entityManager.createQuery("delete from Trip where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}


