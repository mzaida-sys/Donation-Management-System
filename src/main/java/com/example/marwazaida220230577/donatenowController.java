package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class donatenowController implements Initializable {

    @FXML
    private ComboBox<String> familyList;
    @FXML private TextField amountField;
    @FXML private RadioButton cashRadio, foodRadio;
    @FXML private ToggleGroup id_tt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (familyList != null) {
            familyList.getItems().clear();
            for (Family f : DataStorage.families) {
                familyList.getItems().add(f.getName());
            }
        }
        if (id_tt != null) {
            cashRadio.setToggleGroup(id_tt);
            foodRadio.setToggleGroup(id_tt);
        }
    }

    @FXML
    private void donateNow() {
        String family = familyList.getValue();
        String amountStr = amountField.getText();
        Toggle selected = id_tt.getSelectedToggle();

        if (family == null || amountStr.isEmpty() || selected == null) {
            showAlert("Please fill out all information");
            return;
        }

        try {
            double amount = Double.parseDouble(amountStr);
            String type = ((RadioButton) selected).getText();
            String date = LocalDate.now().toString();

            Donation donation = new Donation(family, type, amount, date);


            DataStorage.loggedDonor.donate(donation);

            showAlert("✅ Donation successfully made to " + family + " In the amount of " + amount + " type: " + type);

            amountField.clear();
            familyList.getSelectionModel().clearSelection();
            id_tt.selectToggle(null);
        } catch (NumberFormatException e) {
            showAlert("⚠ The amount must be a valid number");
        }
    }

    @FXML
    private void handleBack() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/marwazaida220230577/donor_main.fxml"));
        Stage stage = (Stage) Window.getWindows().filtered(Window::isShowing).get(0);
        stage.setScene(new Scene(root));
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}