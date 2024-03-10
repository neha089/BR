package DAO;


import Entity.Bus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BusDao {
    private EntityManager entityManager;
    @Autowired
    public BusDao(EntityManager newentitymanager){
        entityManager=newentitymanager;
    }

    public List<Bus> findAll(){

        TypedQuery<Bus> query=entityManager.createQuery("from Bus",Bus.class);
        List<Bus> buses=query.getResultList();
        return buses;
    }
    public Bus findById(int Id){
        Bus buses=entityManager.find(Bus.class,Id);
        return buses;
    }
    public void save (Bus buses){
        Object savebus=entityManager.merge(buses);
    }
    public void deleteById(int Id){
        Query query=entityManager.createQuery("delete from Bus where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}
