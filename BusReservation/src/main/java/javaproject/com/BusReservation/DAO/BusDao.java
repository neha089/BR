package javaproject.com.BusReservation.DAO;



import javaproject.com.BusReservation.Entity.Agency;
import javaproject.com.BusReservation.Entity.Bus;
import javaproject.com.BusReservation.Entity.User;
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
        List<Bus> agencyes=query.getResultList();
        return agencyes;
    }
    public Bus findById(int Id){
        Bus agencyes=entityManager.find(Bus.class,Id);
        return agencyes;
    }
    public void save (Bus agencyes){
        Object savebus=entityManager.merge(agencyes);
    }
    public void deleteById(int Id){
        Query query=entityManager.createQuery("delete from Bus where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}
