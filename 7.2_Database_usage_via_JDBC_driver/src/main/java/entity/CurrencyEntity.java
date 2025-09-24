package entity;

public class CurrencyEntity {

    private String abbreviation, name;
    private double conversion_rate;

    public CurrencyEntity(String abbreviation, String name, double conversion_rate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversion_rate = conversion_rate;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getConversionRate(){
        return conversion_rate;
    }
}
