package com.example.realestategui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

            Statement stmtNames = conn.createStatement();
            ResultSet result = stmtNames.executeQuery("SELECT id, name, phone FROM sellers ORDER BY name ASC;");
            List<String> names = new ArrayList<>();
            while (result.next()){
                names.add(result.getString("name"));
            }

            ObservableList<String> namesOList = FXCollections.observableArrayList(names);
            listView.setItems(namesOList);

            debugger();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}