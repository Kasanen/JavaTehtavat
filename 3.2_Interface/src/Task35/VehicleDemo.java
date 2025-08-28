package Task35;

interface Vehicle {
    void start();
    void stop();
    void getInfo();
}

abstract class AbstractVehicle implements Vehicle {
    protected String fuel;
    protected String color;
    protected String type;
    
    public AbstractVehicle(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
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
        System.out.println();
    }
    
    protected abstract void displaySpecificInfo();
}

class Car extends AbstractVehicle {
    public Car() {
        super("Car", "Petrol", "Red");
    }
    
    @Override
    protected void displaySpecificInfo() {
    }
}

class Motorcycle extends AbstractVehicle {
    public Motorcycle() {
        super("Motorcycle", "Gasoline", "Black");
    }
    
    @Override
    protected void displaySpecificInfo() {
    }
}

class Bus extends AbstractVehicle {
    private final int capacity = 40;
    
    public Bus() {
        super("Bus", "Diesel", "Yellow");
    }
    
    @Override
    protected void displaySpecificInfo() {
        System.out.println("Capacity: " + capacity + " passengers");
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
        
        getVehicle(car);
        getVehicle(motorcycle);
        getVehicle(bus);                
    }
}