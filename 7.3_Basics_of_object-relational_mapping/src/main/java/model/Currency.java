package model;

import java.util.HashMap;
import java.util.List;

import dao.CurrencyDao;
import entity.CurrencyEntity;

public class Currency {

    private HashMap<String, Double> hashMap;
    private static Currency instance;
    CurrencyDao empdao = new CurrencyDao();

    private Currency() {
        this.hashMap = new HashMap<>();
        loadCurrenciesFromDatabase();
    }

    public static Currency getInstance() {
        if (instance == null) {
            instance = new Currency();
        }
        return instance;
    }

    private void loadCurrenciesFromDatabase() {
        List<CurrencyEntity> currencies = empdao.findAll();
        for (CurrencyEntity currency : currencies) {
            hashMap.put(currency.getAbbreviation(), currency.getConversionRate());
        }
    }

    public void addRate(String name, String currency, Double rate) {
        hashMap.put(currency, rate);
    }

    public Double getRate(String currency) {
        Double rate = hashMap.get(currency);
        if (rate == null) {
            return null;
        }
        return rate;
    }

    public java.util.List<CurrencyEntity> getCurrencies() {
        return empdao.findAll();
    }

    public Double convert(Double amount, String cur1, String cur2) {

        Double rate1 = getRate(cur1);
        Double rate2 = getRate(cur2);
        return amount * rate2 / rate1;
    }

    public void refreshCurrencies(){
        loadCurrenciesFromDatabase();
    }
}
