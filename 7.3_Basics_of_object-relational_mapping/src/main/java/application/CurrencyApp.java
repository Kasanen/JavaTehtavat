package application;

import dao.CurrencyDao;
import entity.CurrencyEntity;

public class CurrencyApp {

    public static void main(String[] args) {

        CurrencyDao empdao = new CurrencyDao();

        CurrencyEntity emp = empdao.find(2);
        System.out.println(emp.getAbbreviation() + " " + emp.getConversionRate());
        empdao.update(emp);


    }
}
