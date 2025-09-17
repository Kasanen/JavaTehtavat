package view;

import controller.ProjectController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProjectView extends Application {

    private ProjectController controller;
    private Label result = new Label("Testi");

    public void start(Stage stage) {
        controller = new ProjectController(this);

        this.result.setText("?");

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setHgap(10);
        layout.setVgap(10);

        // row 1
        TextField inputer11 = new TextField();
        GridPane.setMargin(inputer11, new Insets(10));

        Button converter13 = new Button("Convert");
        GridPane.setMargin(converter13, new Insets(10));

        VBox resultBox = new VBox(10, result);
        resultBox.setPadding(new Insets(10));
        resultBox.setStyle("-fx-border-color: gray; -fx-background-color: #f9f9f9;");

        // row 2
        Label text21 = new Label("      From");
        Label text23 = new Label("      To");

        // row 3
        ComboBox<String> drop31 = new ComboBox<>();
        Label text32 = new Label("      --->");
        ComboBox<String> drop33 = new ComboBox<>();

        drop31.getItems().addAll(controller.currencies());
        GridPane.setMargin(drop31, new Insets(10));

        drop33.getItems().addAll(controller.currencies());

        // row 1
        layout.add(inputer11, 0, 0, 2, 1);
        layout.add(converter13, 2, 0);
        layout.add(resultBox, 3, 0);

        // row 2
        layout.add(text21, 0, 1);
        layout.add(text23, 2, 1);

        // row 3
        layout.add(drop31, 0, 2);
        layout.add(text32, 1, 2);
        layout.add(drop33, 2, 2);

        Scene scene = new Scene(layout, 500, 300);
        scene.getStylesheets().add("Style.css");
        stage.setScene(scene);
        stage.setTitle("Currency Converter");
        stage.show();

        converter13.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                String amountText = inputer11.getText();
                Double amount = null;
                try {
                    amount = Double.parseDouble(amountText);
                } catch (NumberFormatException e) {
                    result.setText("Invalid amount");
                    return;
                }

                String cur1 = drop31.getValue();
                String cur2 = drop33.getValue();

                controller.calculate(amount, cur1, cur2);
            }
        });

        stage.show();
    }

    public void setResult(Double result) {
        this.result.setText(String.valueOf(result));
    }
}
