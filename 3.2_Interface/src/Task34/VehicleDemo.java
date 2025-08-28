package Task34;

interface Vehicle {

    void start();

    void stop();

    void getInfo();
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public void getInfo() {
        System.out.println("Type: Car \nFuel: Petrol \nColor: Red \n");
    }
}

class Motorcycle implements Vehicle {

    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public void getInfo() {
        System.out.println("Type: Motorcycle \nFuel: Gasoline \nColor: Black \n");
    }
}

class Bus implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public void getInfo() {
        System.out.println("Type: Bus \nFuel: Diessel \nCapacity: 40 passangers \n");
    }
}

public class VehicleDemo {

    private static void getVehicle(Vehicle vehicle) {
        vehicle.start();
        vehicle.stop();
        vehicle.getInfo();
    }

    public static void main(String[] args) {
        System.out.println("Vehicle Demostration \n");
        getVehicle(new Car());
        getVehicle(new Motorcycle());
        getVehicle(new Bus());
    }
}
