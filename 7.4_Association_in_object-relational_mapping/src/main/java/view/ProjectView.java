package view;

import java.util.List;

import controller.ProjectController;
import entity.CurrencyEntity;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProjectView extends Application {

    private ProjectController controller;
    private Label result = new Label("Testi");

    private ComboBox<String> drop31;
    private ComboBox<String> drop33;

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
        drop31 = new ComboBox<>();
        Label text32 = new Label("      --->");
        drop33 = new ComboBox<>();

        loadCurrencies();

        GridPane.setMargin(drop31, new Insets(10));
        Button adder41 = new Button("Add Currency");

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
        layout.add(adder41, 3, 2);

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

                if ("no databases".equals(cur1) || "no databases".equals(cur2)) {
                    result.setText("no databases");
                    return;
                }

                controller.calculate(amount, cur1, cur2);
            }
        });

        adder41.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                addCurrencyWindow();
            }
        });
    }

    private void loadCurrencies() {
        try {
            drop31.getItems().clear();
            drop33.getItems().clear();

            List<CurrencyEntity> currencies = controller.currencies();
            if (currencies != null && !currencies.isEmpty()) {
                for (CurrencyEntity currency : currencies) {
                    drop31.getItems().add(currency.getAbbreviation());
                    drop33.getItems().add(currency.getAbbreviation());
                }
            } else {
                drop31.getItems().add("no db");
                drop33.getItems().add("no db");
            }
        } catch (Exception e) {
            drop31.getItems().add("no db");
            drop33.getItems().add("no db");
        }
    }

    public void refreshCurrencies(){
        loadCurrencies();
    }

    public void addCurrencyWindow() {
        controller = new ProjectController(this);

        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setHgap(10);
        layout.setVgap(10);

        // row 1
        Label nameLabel = new Label("Currency name:");
        TextField nameField = new TextField();

        // row 2
        Label abbLabel = new Label("Abbreviation:");
        TextField abbField = new TextField();

        // row 3
        Label rateLabel = new Label("Conversion Rate:");
        TextField rateField = new TextField();

        // row 4
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        // row 1
        layout.add(nameLabel, 0, 0);
        layout.add(nameField, 1, 0);

        // row 2
        layout.add(abbLabel, 0, 1);
        layout.add(abbField, 1, 1);

        // row 3
        layout.add(rateLabel, 0, 2);
        layout.add(rateField, 1, 2);

        // row 4
        layout.add(saveButton, 0, 3);
        layout.add(cancelButton, 1, 3);

        Scene newScene = new Scene(layout, 350, 170);
        newStage.setScene(newScene);
        newStage.setTitle("Add Currency");

        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                String nameText = nameField.getText();
                String abbText = abbField.getText();
                String rateText = rateField.getText();

                if (nameText == null || nameText.trim().isEmpty()) {
                    System.out.println("Currency name is required");
                    return;
                }

                if (abbText == null || abbText.trim().isEmpty()) {
                    System.out.println("Abbreviation is required");
                    return;
                }

                if (rateText == null || rateText.trim().isEmpty()) {
                    System.out.println("Conversion rate is required");
                    return;
                }

                Double rate = null;
                try {
                    rate = Double.parseDouble(rateText.trim());
                    if (rate <= 0) {
                        System.out.println("Conversion rate must be positive");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid conversion rate format");
                    return;
                }

                controller.addCurrency(nameText.trim(), abbText.trim().toUpperCase(), rate);
                newStage.close();
            }
        });

        cancelButton.setOnAction(e -> newStage.close());
        newStage.showAndWait();
    }

    public void setResult(Double result) {
        this.result.setText(String.valueOf(result));
    }
}
