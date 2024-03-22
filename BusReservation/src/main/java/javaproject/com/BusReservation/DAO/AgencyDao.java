package javaproject.com.BusReservation.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import javaproject.com.BusReservation.Entity.Agency;
import javaproject.com.BusReservation.Entity.Bus;
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
            List<Agency> agencies=query.getResultList();
            return agencies;
        }
        public Agency findById(int Id){
            Agency agency=entityManager.find(Agency.class,Id);
            return agency;
        }
        public void save (Agency agency){
            Object savebus=entityManager.merge(agency);
        }
        public void deleteById(int Id){
            Query query=entityManager.createQuery("delete from Agency where id=: agencyid");

            query.setParameter("agencyid",Id);
            query.executeUpdate();
        }

    }

