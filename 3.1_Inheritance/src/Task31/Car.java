package Task31;
// Pitääkö gasolineLevelille asentaa omat arvot jotka muuttuvat


/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */
public class Car {

    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    private double speed;
    private double gasolineLevel;
    private final String typeName;

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;   // this refers to the object itself.
        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
            gasolineLevel -= 5;
        } else {
            speed = 0;
            System.out.println("Out of gasoline!");
        }
    }

    public void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0) {
                speed = Math.max(0, speed - amount);
            }
        } else {
            speed = 0;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = 100;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }

    protected void setSpeed(double speed) {
        this.speed = speed;
    }

    protected void setGasolineLevel(double gasolineLevel) {
        this.gasolineLevel = gasolineLevel;
    }

}

class SportsCar extends Car {

    public SportsCar(String typeName) {
        super(typeName);
    }

    @Override
    public void accelerate() {
        if (getGasolineLevel() > 0) {
            setSpeed(getSpeed() + 15);
            setGasolineLevel(getGasolineLevel() - 10);
        } else {
            setSpeed(0);
            System.out.println("Out of gasoline!");
        }
    }

    @Override
    public void decelerate(int amount) {
        if (getGasolineLevel() > 0) {
            if (amount > 0) {
                setSpeed(Math.max(0, getSpeed() - amount * 1.5));
            }
        } else {
            setSpeed(0);
        }
    }
}

class Bus extends Car {

    private int passengers;

    public Bus(String typeName, int passangers) {
        super(typeName);
        this.passengers = passengers;
    }

    public int passengerEnter() {
        passengers += 1;  // or ++passengers
        return passengers;
    }

    public int passengerExit() {
        if (passengers > 0) {
            passengers -= 1;  // or --passengers
            return passengers;
        }
        return passengers;  // Added missing return for else case
    }

    public int getPassengerCount(){
        return passengers;
    }
}
