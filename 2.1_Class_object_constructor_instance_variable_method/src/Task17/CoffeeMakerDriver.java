package Task17;

public class CoffeeMakerDriver {

    public static void main(String[] args) {
        CoffeeMaker CM = new CoffeeMaker();

        CM.pressOnOff();

        CM.setType("espresso");
        CM.setAmount(50);

        System.out.println("Coffee type is " + CM.getType());
        System.out.println("Coffee amount is " + CM.getAmount() + " ml");
        
        CM.pressOnOff();
     }
}
