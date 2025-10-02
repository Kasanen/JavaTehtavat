package entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private double amount;

    @ManyToOne
    private CurrencyEntity currency1;
    @ManyToOne
    private CurrencyEntity currency2;

    public Transaction(double amount, CurrencyEntity cur1, CurrencyEntity cur2) {
        this.amount = amount;
        this.currency1 = cur1;
        this.currency2 = cur2;
    }

    public Transaction(){

    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
}

