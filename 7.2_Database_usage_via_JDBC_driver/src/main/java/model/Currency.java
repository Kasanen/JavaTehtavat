package model;

import java.util.HashMap;

public class Currency {

    private HashMap<String, Double> hashMap;
    private static Currency instance;

    private Currency() {
        this.hashMap = new HashMap<>();
    }

    public static Currency getInstance() {
        if (instance == null) {
            instance = new Currency();
        }
        return instance;
    }

    public void addRate(String currency, Double rate) {
        hashMap.put(currency, rate);
    }

    public Double getRate(String currency) {
        Double rate = hashMap.get(currency);
        if (rate == null) {
            return null;
        }
        return rate;
    }

    public java.util.Set<String> getCurrencies() {
        System.out.println(hashMap.keySet());
        return hashMap.keySet();
    }

    public Double convert(Double amount, String cur1, String cur2) {
        Double rate1 = hashMap.get(cur1);
        Double rate2 = hashMap.get(cur2);
        return amount * rate2 / rate1;
    }
}
