# Calculator program

This is calculator made with Java. Program has ability to sum positive integers. A negative integer throws an exception.
It include following methods:
* A method that resets the calculator to zero.
* A method that adds an integer to the calculator.
* A method that returns the current value of the calculator.

```Java
public class Calculator {

    private int value;

    public Calculator() {
        value = 0;
    }

    public void reset() {
        value = 0;
    }

    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed.");
        }
        value += number;
    }

    public int getValue() {
        return value;
    }

    // Write method signature
    public int sum(int[] numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    // Write method signature and first line
    public int sumWithWhile(int[] numbers) {
        int total = 0;
        int i = 0;
        while (i < numbers.length) {
            total += numbers[i];
            i++;
        }
        return total;
    }

    // Write a comment describing the method
    // Sums all integers in the array using a traditional for loop.
    public int sumWithFor(int[] numbers) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(5);
        System.out.println(calc.getValue()); // 5
        calc.reset();
        System.out.println(calc.getValue()); // 0

        // Demonstrate sum methods
        int[] nums = {2, 4, 6, 8};
        System.out.println("Sum (for-each): " + calc.sum(nums));
        System.out.println("Sum (while): " + calc.sumWithWhile(nums));
        System.out.println("Sum (for): " + calc.sumWithFor(nums));
    }
}
```

# Calculator.java - Code Explanation

This file contains a simple calculator class designed for use in the Model-View-Controller (MVC) pattern. The calculator acts as the "model" and provides basic arithmetic operations and utility methods. Here’s what each part does:

## Features

- **reset()**
  - Sets the calculator’s value back to zero.

- **add(int number)**
  - Adds a positive integer to the calculator’s value.
  - If you try to add a negative number, the method throws an error to prevent invalid input.

- **getValue()**
  - Returns the current value stored in the calculator.

- **sum(int[] numbers)**
  - Calculates and returns the sum of all numbers in an array using a for-each loop.

- **sumWithWhile(int[] numbers)**
  - Calculates and returns the sum of all numbers in an array using a while loop.

- **sumWithFor(int[] numbers)**
  - Calculates and returns the sum of all numbers in an array using a traditional for loop.

## Example Usage

The class includes a temporary `main` method that demonstrates how to use the calculator:

1. Create a Calculator object.
2. Add a number and print the result.
3. Reset the calculator and print the result.
4. Use the sum methods to add up several numbers in different ways and print the results.

## Error Handling

- If you try to add a negative number, the calculator will throw an error and stop the operation. This helps prevent mistakes and keeps the value positive.

---

This calculator class is a good starting point for learning about Java classes, methods, error handling, and the MVC pattern.
