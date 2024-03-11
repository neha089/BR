package javaproject.com.BusReservation.DAO;

import javaproject.com.BusReservation.Entity.Passanger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassangerDao {


        private EntityManager entityManager;
        @Autowired
        public PassangerDao(EntityManager newentitymanager){
            entityManager=newentitymanager;
        }

        public List<Passanger> findAll(){

            TypedQuery<Passanger> query=entityManager.createQuery("from Passanger",Passanger.class);
            List<Passanger> buses=query.getResultList();
            return buses;
        }
        public Passanger findById(int Id){
            Passanger buses=entityManager.find(Passanger.class,Id);
            return buses;
        }
        public void save (Passanger buses){
            Object savebus=entityManager.merge(buses);
        }
        public void deleteById(int Id){
            Query query=entityManager.createQuery("delete from Passanger where id=: busid");

            query.setParameter("busid",Id);
            query.executeUpdate();
        }

    }



