package controller;

import model.Pet;
import view.ProjectView;

public class ProjectController {
    private Pet player;
    private ProjectView gui;

    public ProjectController(ProjectView gui) {
        this.player = new Pet(0, 0);
        this.gui = gui;
    }

    public void handleMove(Double x,Double y) {
        System.out.println("handleMove");
        player.move(x, y);
        gui.updateCanvas(player.getX(), player.getY());
    }

    public double getPlayerX() {
        return player.getX();
    }

    public double getPlayerY() {
        return player.getY();
    }

    public int getGridSize() {
        return player.getGridSize();
    }
}