package Task30;

public class CarDriver {

    public static void main(String[] args) {
        Car regularCar = new Car("Toyota Corolla");
        SportsCar sportsCar = new SportsCar("Ferrari F40");

        regularCar.fillTank();
        sportsCar.fillTank();

        System.out.println("=== Regular car ===");
        for (int i = 0; i < 6; i++) {
            regularCar.accelerate();
            System.out.println(regularCar.getTypeName() + ": speed is " + regularCar.getSpeed() + " km/h");
            System.out.println("Gasoline tank capacity: " + regularCar.getGasolineLevel());
        }

        while (regularCar.getSpeed() > 0) {
            regularCar.decelerate(15);
            System.out.println(regularCar.getTypeName() + ": speed is " + regularCar.getSpeed() + " km/h");
            System.out.println("Gasoline tank capacity: " + regularCar.getGasolineLevel());
        }

        System.out.println("=== Sports car ===");
        for (int i = 0; i < 6; i++) {
            sportsCar.accelerate();
            System.out.println(sportsCar.getTypeName() + ": speed is " + sportsCar.getSpeed() + " km/h");
            System.out.println("Gasoline tank capacity: " + sportsCar.getGasolineLevel());
        }

        while (sportsCar.getSpeed() > 0) {
            sportsCar.decelerate(15);
            System.out.println(sportsCar.getTypeName() + ": speed is " + sportsCar.getSpeed() + " km/h");
            System.out.println("Gasoline tank capacity: " + sportsCar.getGasolineLevel());
        }
    }
}
