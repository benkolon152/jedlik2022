package com.example.realestategui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RealEstateGuiController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}