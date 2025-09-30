package controller;

import dao.CurrencyDao;
import dao.TransactionDao;
import entity.CurrencyEntity;
import entity.Transaction;
import model.Currency;
import view.ProjectView;

public class ProjectController {

    private ProjectView view;
    private Currency currency = Currency.getInstance();
    private CurrencyDao currencyDao = new CurrencyDao();
    private TransactionDao transactionDao = new TransactionDao();

    public ProjectController(ProjectView view) {
        this.view = view;
    }

    public void calculate(Double amount, String cur1, String cur2) {
        Double result = currency.convert(amount, cur1, cur2);
        Double roundedResult = Math.round(result * 100.0) / 100.0;

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(amount);
        transactionDao.persist(newTransaction);

        view.setResult(roundedResult);
    }

    public void addCurrency(String name, String abbreviation, Double rate) {
        CurrencyEntity newCurrency = new CurrencyEntity();

        newCurrency.setName(name);
        newCurrency.setAbbreviation(abbreviation);
        newCurrency.setConversionRate(rate);

        currencyDao.persist(newCurrency);

        Currency.getInstance().refreshCurrencies();
        view.refreshCurrencies();
    }

    public java.util.List<CurrencyEntity> currencies() {
        return currency.getCurrencies();
    }
}
