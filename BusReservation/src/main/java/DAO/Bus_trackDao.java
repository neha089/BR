package DAO;

import Entity.Bus_track;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Bus_trackDao {
    private static EntityManager entityManager;
    @Autowired
    public Bus_trackDao(EntityManager newentitymanager){
        entityManager=newentitymanager;
    }

    public List<Bus_track> findAll(){

        TypedQuery<Bus_track> query=entityManager.createQuery("from Bus_track",Bus_track.class);
        List<Bus_track> buses=query.getResultList();
        return buses;
    }
    public Bus_track findById(int Id){
        Bus_track buses=entityManager.find(Bus_track.class,Id);
        return buses;
    }
    public void save (Bus_track buses){
        Object savebus=entityManager.merge(buses);
    }
    public static void deleteById(int Id){
        Query query=entityManager.createQuery("delete from Bus_track where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}


