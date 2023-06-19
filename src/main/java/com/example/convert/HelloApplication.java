package com.example.convert;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Label kmLabel = new Label("Kilometers:");
        TextField kmTextField = new TextField();
        Label mileLabel = new Label("Miles:");
        TextField mileTextField = new TextField();
        Button convertButton = new Button("Convert");

        // Set up the layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Add the UI controls to the layout
        gridPane.add(kmLabel, 0, 0);
        gridPane.add(kmTextField, 1, 0);
        gridPane.add(mileLabel, 0, 1);
        gridPane.add(mileTextField, 1, 1);
        gridPane.add(convertButton, 0, 2, 2, 1);

        // Set up the event handler for the convert button
        convertButton.setOnAction(event -> {
            try {
                // Parse the input as a double
                double kilometers = Double.parseDouble(kmTextField.getText());

                // Convert kilometers to miles
                double miles = kilometers * 0.621371;

                // Display the result in the miles text field
                mileTextField.setText(String.format("%.2f", miles));
            } catch (NumberFormatException e) {
                // Display an error message if the input is not a valid number
                mileTextField.setText("");
                kmTextField.setText("");
                kmTextField.requestFocus();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION.ERROR, "Invalid input. Please enter a number.");
                alert.showAndWait();
            }
        });

        // Set up the scene and show the window
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setTitle("Kilometer to Mile Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }








    public static void main(String[] args) {
        launch();
    }
}

