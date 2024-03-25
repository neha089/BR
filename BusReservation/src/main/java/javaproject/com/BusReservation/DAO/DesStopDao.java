package javaproject.com.BusReservation.DAO;



import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import javaproject.com.BusReservation.Entity.DesStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DesStopDao {
    private EntityManager entityManager;
    @Autowired
    public DesStopDao(EntityManager newentitymanager){
        entityManager=newentitymanager;
    }

    public List<DesStop> findAll(){

        TypedQuery<DesStop> query=entityManager.createQuery("from DesStop",DesStop.class);
        List<DesStop> agencyes=query.getResultList();
        return agencyes;
    }
    public DesStop findById(int Id){
        DesStop agencyes=entityManager.find(DesStop.class,Id);
        return agencyes;
    }
    public void save (DesStop agencyes){
        Object savebus=entityManager.merge(agencyes);
    }
    public void deleteById(int Id){
        Query query=entityManager.createQuery("delete from DesStop where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}
