package Task18;

public class Car {

    private double speed;
    private double gasolineLevel;
    private final String typeName;

    // Cruise control variables
    private boolean cruiseControlOn;
    private double targetSpeed;
    private int MIN_CRUISE_SPEED = 30;
    private int MAX_CRUISE_SPEED = 120;

    public Car(String typeName) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
        this.cruiseControlOn = false;
        this.targetSpeed = 0;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 1; 
            gasolineLevel -= 0.5;
        } else {
            System.out.println("Out of gasoline!");
            turnOffCruiseControl();
        }
    }

    public void decelerate(double amount) {
        speed = Math.max(0, speed - amount);
    }

    public void setCruiseControlSpeed(double targetSpeed) {
        if (cruiseControlOn == false) {
            System.out.println("Cruise control is off!");
        } else if (targetSpeed >= MIN_CRUISE_SPEED && targetSpeed <= MAX_CRUISE_SPEED && cruiseControlOn == true) {
            this.targetSpeed = targetSpeed;
        } else {
            System.out.println("Unable to set target speed. \n !!!");
            cruiseControlOn = false;
        }
    }

    public double getCruiseControlSpeed() {
        return this.targetSpeed;
    }

    public boolean turnOnCruiseControl() {
        cruiseControlOn = true;
        System.out.println("Cruise control turned on");
        return true;
    }

    public void turnOffCruiseControl() {
        cruiseControlOn = false;
        System.out.println("Cruise control turned off");
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }


    // Existing methods
    public void fillTank() {
        gasolineLevel = 100;
    }

    public double getSpeed() {
        return speed;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }

    public String getTypeName() {
        return typeName;
    }
}
