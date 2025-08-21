package Task17;

public class CoffeeMaker {

    private boolean isOn;
    private String type;
    private int amount;

    public CoffeeMaker() {
        this.isOn = false;
        this.type = "normal";
        this.amount = 10;
    }

    public void setType(String type){
        if (isOn){
            this.type = type;
        }
    }

    public void setAmount(int amount){
        if (isOn && amount >= 10 && amount <= 80){
            this.amount = amount;
        }
    }

    public String getType() {
        return this.type;
    }

    public int getAmount() {
        return this.amount;
    }

    public void pressOnOff() {
        this.isOn = !this.isOn;
        if (!isOn){
            System.out.println("Coffee maker is off");
        }
        else {
            System.out.println("Coffee maker is on");
        }
    }

    public boolean isOn() {
        return this.isOn;
    }
}
