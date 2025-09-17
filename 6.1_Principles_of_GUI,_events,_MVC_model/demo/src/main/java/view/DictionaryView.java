package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private TextField wordField = new TextField();
    private DictionaryController controller;
    private Label result = new Label("");

    public void start(Stage stage) {
        wordField.setPromptText("Enter word!");
        wordField.setMaxWidth(150);

        Button searchButton = new Button("Search");
        controller = new DictionaryController(this);

        this.result.setText(String.valueOf(controller.words()));

        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);

        VBox resultBox = new VBox(10, result);
        resultBox.setPadding(new Insets(10));
        resultBox.setStyle("-fx-border-color: gray; -fx-background-color: #f9f9f9;");

        pane.getChildren().addAll(wordField, searchButton, resultBox);


        Scene scene = new Scene(pane, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Dictionary");
        stage.show();

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String wordSearch = wordField.getText();
                if (wordSearch.trim().isEmpty()) {
                    setResult("The state of being nothing; complete emptiness.");
                } else {
                    controller.search(wordSearch);
                }
            }
        });

        stage.show();
    }

    public void setResult(String result) {
        this.result.setText(String.valueOf(result));
    }
}
