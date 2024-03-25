package javaproject.com.BusReservation.DAO;



import javaproject.com.BusReservation.Entity.SouStop;
import javaproject.com.BusReservation.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SouStopDao {
    private EntityManager entityManager;
    @Autowired
    public SouStopDao(EntityManager newentitymanager){
        entityManager=newentitymanager;
    }

    public List<SouStop> findAll(){

        TypedQuery<SouStop> query=entityManager.createQuery("from SouStop",SouStop.class);
        List<SouStop> agencyes=query.getResultList();
        return agencyes;
    }
    public SouStop findById(int Id){
        SouStop agencyes=entityManager.find(SouStop.class,Id);
        return agencyes;
    }
    public void save (SouStop agencyes){
        Object savebus=entityManager.merge(agencyes);
    }
    public void deleteById(int Id){
        Query query=entityManager.createQuery("delete from SouStop where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}




    

