package com.example.realestategui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RealEstateGuiController implements Initializable{
    @FXML public ListView<String> listView;
    @FXML
    private Label welcomeText;

    public Connection conn;

    public void debugger(){int i = 0;}

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingatlanok", "root", "");
            debugger();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}