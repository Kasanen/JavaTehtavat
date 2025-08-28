package Task37;

interface Vehicle {

    void start();

    void stop();

    void getInfo();

    void calculateFuelEffeciency();
}

interface ElectricVehicle {

    void charge();
}

abstract class AbstractVehicle implements Vehicle {

    protected String fuel;
    protected String color;
    protected String type;
    protected double fuelEfficiency;
    protected String efficiencyUnit;

    public AbstractVehicle(String type, String fuel, String color, double fuelEfficiency, String efficiencyUnit) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.fuelEfficiency = fuelEfficiency;
        this.efficiencyUnit = efficiencyUnit;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public void getInfo() {
        System.out.println("Type: " + type + " \nFuel: " + fuel + " \nColor: " + color);
        displaySpecificInfo();
        calculateFuelEffeciency();
        System.out.println();
    }

    @Override
    public void calculateFuelEffeciency() {
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " " + efficiencyUnit);
    }

    protected abstract void displaySpecificInfo();

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

    public Car() {
        super("Car", "Petrol", "Red", 25.0, "miles per gallon");
    }

    @Override
    protected void displaySpecificInfo() {
    }

    @Override
    boolean canCharge() {
        return false;
    }
}

class Motorcycle extends AbstractVehicle {

    public Motorcycle() {
        super("Motorcycle", "Gasoline", "Black", 45.0, "miles per gallon");
    }

    @Override
    protected void displaySpecificInfo() {
    }

    @Override
    boolean canCharge() {
        return false;
    }
}

class Bus extends AbstractVehicle {

    private final int capacity = 40;

    public Bus() {
        super("Bus", "Diesel", "Yellow", 8.0, "miles per gallon");
    }

    @Override
    protected void displaySpecificInfo() {
        System.out.println("Capacity: " + capacity + " passengers");
    }

    @Override
    boolean canCharge() {
        return false;
    }
}

// Electric vehicles
class ElectricCar extends AbstractVehicle implements ElectricVehicle {

    public ElectricCar() {
        super("Electric Car", "Electric", "White", 4.5, "kWh per 100km");
    }

    @Override
    protected void displaySpecificInfo() {
    }

    @Override
    boolean canCharge() {
        return true;
    }

    @Override
    public void charge() {
        System.out.println("Charging!");
    }

    @Override
    public void calculateFuelEffeciency() {
        System.out.println("Energy Efficiency: " + fuelEfficiency + " " + efficiencyUnit);
    }
}

class ElectricMotorcycle extends AbstractVehicle implements ElectricVehicle {
    public ElectricMotorcycle() {
        super("Electric Motorcycle", "Electric", "Blue", 3.2, "kWh per 100km");
    }

    @Override
    protected void displaySpecificInfo() {
        System.out.println("Vehicle Class: Electric Two-Wheeler");
    }

    @Override
    boolean canCharge() {
        return true;
    }

    @Override
    public void charge() {
        System.out.println("Charging!");
    }

    @Override
    public void calculateFuelEffeciency() {
        System.out.println("Energy Efficiency: " + fuelEfficiency + " " + efficiencyUnit);
    }

    @Override
    public void start() {
        System.out.println(type + " is starting silently...");
    }
}

public class VehicleDemo {

    private static void getVehicle(AbstractVehicle vehicle) {
        vehicle.start();
        vehicle.stop();
        vehicle.getInfo();

    }

    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration \n");

        Car car = new Car();
        Motorcycle motorcycle = new Motorcycle();
        Bus bus = new Bus();
        ElectricCar electricCar = new ElectricCar();
        ElectricMotorcycle electricMotorcycle = new ElectricMotorcycle();

        getVehicle(car);
        getVehicle(motorcycle);
        getVehicle(bus);
        getVehicle(electricCar);
        getVehicle(electricMotorcycle);
    }
}
