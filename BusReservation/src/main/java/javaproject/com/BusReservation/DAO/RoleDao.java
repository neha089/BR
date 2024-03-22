package javaproject.com.BusReservation.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import javaproject.com.BusReservation.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public class RoleDao {
        private EntityManager entityManager;
        @Autowired
        public RoleDao(EntityManager newentitymanager){
            entityManager=newentitymanager;
        }

        public List<Role> findAll(){

            TypedQuery<Role> query=entityManager.createQuery("from Role",Role.class);
            List<Role> roles=query.getResultList();
            return roles;
        }
        public Role findById(int Id){
            Role roles=entityManager.find(Role.class,Id);
            return roles;
        }
        public void save (Role roles){
            Object savebus=entityManager.merge(roles);
        }
        public void deleteById(int Id){
            Query query=entityManager.createQuery("delete from Role where id=: busid");

            query.setParameter("busid",Id);
            query.executeUpdate();
        }

    }

