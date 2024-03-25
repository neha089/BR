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
            List<Passanger> passangers=query.getResultList();
            return passangers;
        }
        public Passanger findById(int Id){
            Passanger passangers=entityManager.find(Passanger.class,Id);
            return passangers;
        }
        public void save (Passanger passangers){
             passangers=entityManager.merge(passangers);
        }
        public void deleteById(int Id){
            Query query=entityManager.createQuery("delete from Passanger where id=: busid");

            query.setParameter("busid",Id);
            query.executeUpdate();
        }

    }



