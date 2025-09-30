package application;

import dao.CurrencyDao;
import dao.TransactionDao;
import entity.CurrencyEntity;
import entity.Transaction;

public class CurrencyApp {
    public static void main(String[] args) {
        
        CurrencyDao empdao = new CurrencyDao();
        TransactionDao trandao = new TransactionDao();

        Transaction t1 = new Transaction(500);

        trandao.persist(t1);

        CurrencyEntity emp = empdao.find(2);
        System.out.println(emp.getAbbreviation() + " " + emp.getConversionRate());
        empdao.update(emp);


    }
}
