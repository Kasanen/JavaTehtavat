package view;

import controller.ProjectController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ProjectView extends Application {

    private static final int CELL_SIZE = 100;

    private Canvas canvas;
    private GraphicsContext gc;
    private ProjectController controller;
    private boolean running = false;
    private double mouseX, mouseY;
    private Thread loopThread;
    private Image petImage;

    @Override
    public void init() {
        controller = new ProjectController(this);
    }

    @Override
    public void start(Stage primaryStage) {
        int gridSize = controller.getGridSize();
        int canvasSize = gridSize * CELL_SIZE;
        canvas = new Canvas(canvasSize, canvasSize);
        gc = canvas.getGraphicsContext2D();
        petImage = new Image("file:src/main/resources/pet.png");

        canvas.setFocusTraversable(true);
        canvas.setOnMouseMoved(event -> {
            mouseX = event.getX();
            mouseY = event.getY();
        });

        canvas.setOnMouseEntered(event -> {
            running = true;
            mouseX = event.getX();
            mouseY = event.getY();

            loopThread = new Thread(() -> {
                while (running) {
                    Platform.runLater(() -> {
                        controller.handleMove(mouseX, mouseY);
                        updateCanvas(controller.getPlayerX(), controller.getPlayerY());
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            loopThread.start();
        });

        canvas.setOnMouseExited(event -> {
            running = false;
            if (loopThread != null) {
                loopThread.interrupt();
            }
        });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, canvasSize, canvasSize);
        primaryStage.setTitle("Pet Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();

        updateCanvas(controller.getPlayerX(), controller.getPlayerY());
    }

    public void updateCanvas(double playerX, double playerY) {
        int gridSize = controller.getGridSize();
        int canvasSize = gridSize * CELL_SIZE;

        gc.clearRect(0, 0, canvasSize, canvasSize);

        double x = playerX * CELL_SIZE;
        double y = playerY * CELL_SIZE;
        gc.drawImage(petImage, x, y, CELL_SIZE, CELL_SIZE);
    }
}
