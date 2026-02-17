package org.Hibernate_spring.repository;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Object obj){
        em.persist(obj);
    }

    public List<?> findAll(){
        return em.createQuery("from User").getResultList();
    }

    public void delete(Object obj){
        em.remove(em.contains(obj) ? obj : em.merge(obj));
    }
}
