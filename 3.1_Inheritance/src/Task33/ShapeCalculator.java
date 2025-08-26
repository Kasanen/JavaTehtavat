package Task33;

class Shape {

    private final String shapeName;
    private final String color;

    public Shape(String shapeName, String color) {
        this.shapeName = shapeName;
        this.color = color;
    }

    public String getShapeName() {
        return shapeName;
    }

    public String getColor(){
        return color;
    }

    @Override
    public String toString() {
        return shapeName;
    }
}

class Circle extends Shape {

    private double numb1;

    public Circle(String shape, String color, double numb1) {
        super(shape, color);
        this.numb1 = numb1;
    }

    public double calculateArea() {
        return Math.PI * numb1 * numb1;
    }

    @Override
    public String toString() {
        return "Area of " + getColor() + " " + getShapeName() + " with radius " + numb1 + ": " + calculateArea();
    }
}

class Rectangle extends Shape {

    private double numb1;
    private double numb2;

    public Rectangle(String shape, String color, double numb1, double numb2) {
        super(shape, color);
        this.numb1 = numb1;
        this.numb2 = numb2;
    }

    public double calculateArea() {
        return numb1 * numb2;
    }

    @Override
    public String toString() {
        return "Area of " + getColor() + " " + getShapeName() + " with width " + numb1 + " and height " + numb2 + ": " + calculateArea();
    }
}

class Triangle extends Shape {

    private double numb1;
    private double numb2;

    public Triangle(String shape, String color, double numb1, double numb2) {
        super(shape, color);
        this.numb1 = numb1;
        this.numb2 = numb2;
    }

    public double calculateArea() {
        return 0.5 * numb1 * numb2;
    }

    @Override
    public String toString() {
        return "Area of " + getColor() + " " + getShapeName() + " with base " + numb1 + " and height " + numb2 + ": " + calculateArea();
    }
}

public class ShapeCalculator {

    public static void main(String[] args) {

        System.out.println("Shape Calculator \n");

        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("Circle", "Red", 5.0);
        shapes[1] = new Rectangle("Rectangle", "Green", 4.0, 6.0);
        shapes[2] = new Triangle("Triangle", "Blue", 3.0, 8.0);

        for (int i = 0; i < shapes.length; i++) {
            System.out.println((i + 1) + ". " + shapes[i]);
        }
    }
}
