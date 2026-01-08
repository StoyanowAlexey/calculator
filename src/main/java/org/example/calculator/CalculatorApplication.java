package org.example.calculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CalculatorApplication extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        scene.getStylesheets().add(
                Objects.requireNonNull(
                        CalculatorApplication.class.getResource("/css/design.css")
                ).toExternalForm()
        );
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}