package model;

public class Pet {
    private double x;
    private double y;
    private static final int GRID_SIZE = 10;

    public Pet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(Double notMouseX, Double notMouseY) {
        Double mouseY = notMouseY / 100;
        Double mouseX = notMouseX / 100;
        if (mouseY != y && mouseY < y){
            y -= 0.1;
        } 
        
        if (mouseY != y && mouseY > y){
            y += 0.1;
        }

        if (mouseX != x && mouseX < x){
            x -= 0.1;
        }
        
        if (mouseX != x && mouseX > x){
            x += 0.1;
        }

        x = Math.max(0, Math.min(x, GRID_SIZE - 1));
        y = Math.max(0, Math.min(y, GRID_SIZE - 1));
        System.out.println("Player moved to (" + x + ", " + y + ")");
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static int getGridSize() {
        return GRID_SIZE;
    }
}