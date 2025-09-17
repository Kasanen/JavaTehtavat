package model;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, Double> dictionary;

    public Dictionary(){
        this.dictionary = new HashMap<>();
        addRate("USD", 1.00); // BASE rate
        addRate("EUR", 0.85);
        addRate("GBP", 0.73);
    }
    
    public void addRate(String currency, Double rate){
        dictionary.put(currency, rate);
    }

    public Double getRate(String currency) {
        Double rate = dictionary.get(currency);
        if (rate == null) {
            return null;
        }
        return rate;
    }

    public java.util.Set<String> getCurrencies() {
        return dictionary.keySet();
    }

    public Double convert(Double amount, String cur1, String cur2){
        Double rate1 = dictionary.get(cur1);
        Double rate2 = dictionary.get(cur2);
        return amount * rate2 / rate1;
    }
}
