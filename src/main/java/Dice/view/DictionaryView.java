package Dice.view;

import Dice.controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private TextField wordField = new TextField();
    private Label resultLabel = new Label("Enter a word and press Search.");
    private DictionaryController controller;

    public void init() {
        controller = new DictionaryController();
    }

    public void start(Stage stage) {
        Button searchButton = new Button("Search");
        FlowPane pane = new FlowPane();

        stage.setTitle("Virtual Dictionary");

        Insets insets = new Insets(10, 10, 10, 10);
        pane.setMargin(wordField, insets);
        pane.setMargin(searchButton, insets);
        pane.setMargin(resultLabel, insets);

        wordField.setPromptText("Type a word...");

        pane.getChildren().add(wordField);
        pane.getChildren().add(searchButton);
        pane.getChildren().add(resultLabel);


        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String result = controller.search(wordField.getText());
                resultLabel.setText(result);
            }
        });

        Scene scene = new Scene(pane, 300,150);
        stage.setScene(scene);
        stage.show();
    }
}