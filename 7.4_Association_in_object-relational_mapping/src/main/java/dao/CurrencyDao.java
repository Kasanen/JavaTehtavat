package dao;

import java.util.List;

import entity.CurrencyEntity;
import jakarta.persistence.EntityManager;

public class CurrencyDao {

    public void persist(CurrencyEntity emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    public CurrencyEntity find(String abbreviation) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        List<CurrencyEntity> emp = em.createQuery("select e from CurrencyEntity e").getResultList();
        for(CurrencyEntity e : emp){
            if (e.getAbbreviation().equals(abbreviation)){
                return e;
            }
        }
        return null;
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
