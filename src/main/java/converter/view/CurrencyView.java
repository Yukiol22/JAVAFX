package converter.view;

import converter.controller.CurrencyController;
import converter.model.Currency;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CurrencyView extends Application {

    private CurrencyController controller;

    private TextField amountField = new TextField();
    private TextField resultField = new TextField();
    private ChoiceBox<Currency> fromBox = new ChoiceBox<>();
    private ChoiceBox<Currency> toBox = new ChoiceBox<>();

    public void init() {
        controller = new CurrencyController();
    }

    public void start(Stage stage) {
        stage.setTitle("Currency Converter");


        Label instructions = new Label("Enter an amount, choose two currencies and press Convert.");
        Label fromLabel = new Label("From:");
        Label toLabel = new Label("To:");
        Label amountLabel = new Label("Amount:");
        Label resultLabel = new Label("Result:");


        Button convertButton = new Button("Convert");


        fromBox.setItems(FXCollections.observableArrayList(controller.getCurrencies()));
        toBox.setItems(FXCollections.observableArrayList(controller.getCurrencies()));

        GridPane grid = new GridPane();
        grid.add(fromLabel, 0, 0);
        grid.add(toLabel, 1, 0);
        grid.add(fromBox, 0, 1);
        grid.add(toBox, 1, 1);
        grid.add(amountLabel, 0, 2);
        grid.add(resultLabel, 1, 2);
        grid.add(amountField, 0, 3);
        grid.add(resultField, 1, 3);

        Insets insets = new Insets(5, 10, 5, 0);
        GridPane.setMargin(fromBox, insets);
        GridPane.setMargin(toBox, insets);
        GridPane.setMargin(amountField, insets);
        GridPane.setMargin(resultField, insets);

        VBox layout = new VBox();
        layout.getChildren().add(instructions);
        layout.getChildren().add(grid);
        layout.getChildren().add(convertButton);


        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String result = controller.convert(amountField.getText(), fromBox.getValue(), toBox.getValue());
                resultField.setText(result);
            }
        });

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
}