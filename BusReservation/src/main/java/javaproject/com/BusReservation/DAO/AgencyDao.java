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
public class AgencyDao {
    private EntityManager entityManager;
    @Autowired
    public AgencyDao(EntityManager newentitymanager){
        entityManager=newentitymanager;
    }

    public List<Agency> findAll(){

        TypedQuery<Agency> query=entityManager.createQuery("from Agency",Agency.class);
        List<Agency> agencyes=query.getResultList();
        return agencyes;
    }
    public Agency findById(int Id){
        Agency agencyes=entityManager.find(Agency.class,Id);
        return agencyes;
    }
    public void save (Agency agencyes){
        Object savebus=entityManager.merge(agencyes);
    }
    public void deleteById(int Id){
        Query query=entityManager.createQuery("delete from Agency where id=: busid");

        query.setParameter("busid",Id);
        query.executeUpdate();
    }

}
