package dao;

import entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    public void persist(Transaction tran) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(tran);
        em.getTransaction().commit();
    }

    public Transaction find(int id){
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        Transaction tran = em.find(Transaction.class, id);
        return tran;
    }
}
