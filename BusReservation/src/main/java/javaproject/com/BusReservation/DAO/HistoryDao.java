package javaproject.com.BusReservation.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import javaproject.com.BusReservation.Entity.Bus;
import javaproject.com.BusReservation.Entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryDao {

    private EntityManager entityManager;

    @Autowired
    public HistoryDao(EntityManager newentitymanager) {
        entityManager = newentitymanager;
    }

    public List<History> findAll() {

        TypedQuery<History> query = entityManager.createQuery("from History", History.class);
        List<History> histories = query.getResultList();
        return histories;
    }

    public History findById(int Id) {
        History histories = entityManager.find(History.class, Id);
        return histories;
    }

    public void save(History histories) {
        Object savebus = entityManager.merge(histories);
    }

    public void deleteById(int Id) {
        Query query = entityManager.createQuery("delete from History where id=: busid");

        query.setParameter("busid", Id);
        query.executeUpdate();
    }
}

