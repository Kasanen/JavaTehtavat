package application;

import java.util.List;

import dao.CurrencyDao;
import entity.CurrencyEntity;
import model.Currency;
import view.ProjectView;

public class CompanyApp {

    public static void main(String[] args) {

        CurrencyDao empdao = new CurrencyDao();
        Currency currency = Currency.getInstance();

        List<CurrencyEntity> currencies = empdao.getAllCurrencyEntitys();
        for (CurrencyEntity emp : currencies) {
            System.out.println(emp.getAbbreviation() + " " + emp.getConversionRate());
            currency.addRate(emp.getAbbreviation(), emp.getConversionRate());

        }

        datasource.MariaDbConnection.terminate();
        ProjectView.launch(ProjectView.class);
    }
}
