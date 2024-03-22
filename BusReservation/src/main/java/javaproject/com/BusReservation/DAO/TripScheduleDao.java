package javaproject.com.BusReservation.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import javaproject.com.BusReservation.Entity.TripSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public class TripScheduleDao {
        private EntityManager entityManager;

        @Autowired
        public TripScheduleDao(EntityManager newentitymanager) {
            entityManager = newentitymanager;
        }

        public List<TripSchedule> findAll() {

            TypedQuery<TripSchedule> query = entityManager.createQuery("from TripSchedule", TripSchedule.class);
            List<TripSchedule> tripschedules = query.getResultList();
            return tripschedules;
        }

        public TripSchedule findById(int Id) {
            TripSchedule tripschedules = entityManager.find(TripSchedule.class, Id);
            return tripschedules;
        }

        public void save(TripSchedule tripschedules) {
            Object savebus = entityManager.merge(tripschedules);
        }

        public void deleteById(int Id) {
            Query query = entityManager.createQuery("delete from TripSchedule where id=: busid");

            query.setParameter("busid", Id);
            query.executeUpdate();
        }

    }


