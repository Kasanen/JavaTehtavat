package Task36;

interface ElectricVehicle {

    void charge();
}

abstract class AbstractVehicle {

    protected String vehicle;

    public AbstractVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void start() {
        System.out.println(vehicle + " is starting...");
    }

    public void stop() {
        System.out.println(vehicle + " is stopping...");
    }

    abstract void getInfo();

    abstract boolean canCharge();

    public void charge() {
        if (canCharge()) {
            System.out.println("Charging!");
        } else {
            System.out.println("Not possible to charge.");
        }
    }
}

class Car extends AbstractVehicle {

    private String fuel;
    private String color;

    public Car(String vehicle, String fuel, String color) {
        super(vehicle);
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    void getInfo() {
        System.out.println("Type: " + vehicle + "\nFuel: " + fuel + "\nColor: " + color);
    }

    @Override
    boolean canCharge(){
        return false;
    }
}

class Motorcycle extends AbstractVehicle {

    private String fuel;
    private String color;

    public Motorcycle(String vehicle, String fuel, String color) {
        super(vehicle);
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    void getInfo() {
        System.out.println("Type: " + vehicle + "\nFuel: " + fuel + "\nColor: " + color);
    }

    @Override
    boolean canCharge(){
        return false;
    }
}

class Bus extends AbstractVehicle {

    private String fuel;
    private int capacity;

    public Bus(String vehicle, String fuel, int capacity) {
        super(vehicle);
        this.fuel = fuel;
        this.capacity = capacity;
    }

    @Override
    void getInfo() {
        System.out.println("Type: " + vehicle + "\nFuel: " + fuel + "\nCapacity: " + capacity + " passangers");
    }

    @Override
    boolean canCharge(){
        return false;
    }
}

// Electric
class ElectricCar extends AbstractVehicle {

    private String color;
    private String fuel;


    public ElectricCar(String vehicle, String fuel, String color) {
        super(vehicle);
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    void getInfo() {
        System.out.println("Type: " + vehicle + "\nFuel: " + fuel + "\nColor: " + color);
    }

    @Override
    boolean canCharge(){
        return true;
    }
}

class ElectricMotorcycle extends AbstractVehicle {

    private String color;
    private String fuel;


    public ElectricMotorcycle(String vehicle, String fuel, String color) {
        super(vehicle);
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    void getInfo() {
        System.out.println("Type: " + vehicle + "\nFuel: " + fuel + "\nColor: " + color);
    }

    @Override
    boolean canCharge(){
        return true;
    }
}

public class VehicleDemo {

    public static void main(String[] args) {
        System.out.println("Vehicle Demostration \n");
        ElectricCar electricCar = new ElectricCar("Electric car", "Electric", "White");
        electricCar.start();
        electricCar.stop();
        electricCar.getInfo();
        electricCar.charge();
        System.out.println();

        ElectricMotorcycle electricMotorcycle = new ElectricMotorcycle("Electric motorcycle", "Electric", "Green");
        electricMotorcycle.start();
        electricMotorcycle.stop();
        electricMotorcycle.getInfo();
        electricMotorcycle.charge();
        System.out.println();

        Bus bus = new Bus("Bus", "Diesel", 40);
        bus.start();
        bus.stop();
        bus.getInfo();
        bus.charge();
    }
}
