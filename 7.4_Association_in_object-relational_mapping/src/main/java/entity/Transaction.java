package entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private double amount;

    public Transaction(double amount) {
        this.amount = amount;
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

