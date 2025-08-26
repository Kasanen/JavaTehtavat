package Task31;

public class CarDriver {

    public static void main(String[] args) {
        Bus bus = new Bus("City Bus", 0);
        bus.fillTank();

        System.out.println("Passengers: " + bus.getPassengerCount());
        bus.passengerEnter();
        bus.passengerEnter();

        for (int i = 0; i < 6; i++) {
            bus.accelerate();
            System.out.println(bus.getTypeName() + ": speed is " + bus.getSpeed() + " km/h");
            System.out.println("Gasoline tank capacity: " + bus.getGasolineLevel());
        }

        while (bus.getSpeed() > 0) {
            bus.decelerate(15);
            System.out.println(bus.getTypeName() + ": speed is " + bus.getSpeed() + " km/h");
            System.out.println("Gasoline tank capacity: " + bus.getGasolineLevel());
        }

        bus.passengerExit();
        System.out.println("Passangers: " + bus.getPassengerCount());
    }
}
