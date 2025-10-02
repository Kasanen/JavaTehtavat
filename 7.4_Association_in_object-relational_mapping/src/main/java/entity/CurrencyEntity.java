package entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CurrencyEntity")

public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="abbreviation")
    private String abbreviation;
    @Column(name="name")
    private String name;
    @Column(name="conversionRate")
    private double conversionRate;
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private entity.Transaction transaction;

    public CurrencyEntity(String abbreviation, String name, double conversion_rate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversionRate = conversion_rate;
    }

    public CurrencyEntity(){

    }

    public void setTransaction(Transaction transaction){
        this.transaction = transaction;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getConversionRate(){
        return conversionRate;
    }
}
