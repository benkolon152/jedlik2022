package com.example.realestategui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    @FXML public Label labelSeller;
    @FXML public Label labelPhone;
    @FXML public Label labelAds;
    @FXML public Button buttonAds;
    @FXML
    private Label welcomeText;

    public Connection conn;

    public List<String> names;

    public List<String> phones;

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
            names = new ArrayList<>();
            phones = new ArrayList<>();
            while (result.next()){
                names.add(result.getString("name"));
                phones.add(result.getString("phone"));
            }

            ObservableList<String> namesOList = FXCollections.observableArrayList(names);
            listView.setItems(namesOList);

            listView.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        onSellerSelected();
                    }
            );

            debugger();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onSellerSelected(){
        String selectedName = listView.getSelectionModel().getSelectedItem();
        System.out.println(selectedName);
        labelSeller.setText("Eladó neve: " + selectedName);
        for (int i = 0; i < names.size(); i++){
            if (names.get(i) == selectedName){
                labelPhone.setText("Eladó telefonszáma: " + phones.get(i));
            }
        }
    }

    public void onAdLoad(ActionEvent actionEvent) throws SQLException {
        String selectedName = listView.getSelectionModel().getSelectedItem();
        System.out.println(selectedName);

        PreparedStatement stmtCount = conn.prepareStatement("""
                SELECT COUNT(realestates.id) AS CNT
                FROM realestates
                INNER JOIN sellers ON sellers.id = realestates.sellerId
                WHERE sellers.name = ?
                """);
        stmtCount.setString(1, selectedName);
        ResultSet result = stmtCount.executeQuery();
        while (result.next()){
            int count = result.getInt("CNT");
            labelAds.setText("Hírdetések száma: " + count);
        }
    }
}