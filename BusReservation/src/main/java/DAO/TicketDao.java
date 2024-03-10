package DAO;

import Entity.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDao {


        private EntityManager entityManager;
        @Autowired
        public TicketDao(EntityManager newentitymanager){
            entityManager=newentitymanager;
        }

        public List<Ticket> findAll(){

            TypedQuery<Ticket> query=entityManager.createQuery("from Ticket",Ticket.class);
            List<Ticket> buses=query.getResultList();
            return buses;
        }
        public Ticket findById(int Id){
            Ticket buses=entityManager.find(Ticket.class,Id);
            return buses;
        }
        public void save (Ticket buses){
            Object savebus=entityManager.merge(buses);
        }
        public void deleteById(int Id){
            Query query=entityManager.createQuery("delete from Ticket where id=: busid");

            query.setParameter("busid",Id);
            query.executeUpdate();
        }

    }



