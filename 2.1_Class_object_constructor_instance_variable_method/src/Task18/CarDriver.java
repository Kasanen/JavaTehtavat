package Task18;

import java.util.Scanner;

public class CarDriver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car myCar = new Car("Toyota Corolla");
        myCar.fillTank();

        myCar.turnOnCruiseControl();

        while (myCar.isCruiseControlOn()) {
            System.out.println("Set cruise control target: ");
            int target = sc.nextInt();

            myCar.setCruiseControlSpeed(target);
            System.out.println("Target speed: " + myCar.getCruiseControlSpeed() + " km/h");

            if (myCar.isCruiseControlOn()) {
                if (myCar.getCruiseControlSpeed() >= myCar.getSpeed()) {
                    while (myCar.getSpeed() < myCar.getCruiseControlSpeed()) {
                        myCar.accelerate();

                        // Bensa check
                        if (!myCar.isCruiseControlOn()){
                            break;
                        }
                    }
                } else if (myCar.getCruiseControlSpeed() <= myCar.getSpeed()) {
                    while (myCar.getSpeed() > myCar.getCruiseControlSpeed()) {
                        myCar.decelerate(1);
                    }
                }
            }
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
            System.out.println("Gasoline tank capacity: " + myCar.getGasolineLevel());
        }
    }
}
