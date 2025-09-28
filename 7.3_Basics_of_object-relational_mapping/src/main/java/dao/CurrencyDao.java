package dao;

import entity.CurrencyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class CurrencyDao {

    public void persist(CurrencyEntity emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    public CurrencyEntity find(int id) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        CurrencyEntity emp = em.find(CurrencyEntity.class, id);
        return emp;
    }

    public List<CurrencyEntity> findAll() {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        List<CurrencyEntity> emps = em.createQuery("select e from CurrencyEntity e").getResultList();
        return emps;
    }

    public void update(CurrencyEntity emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
    }

    public void delete(CurrencyEntity emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }
}
