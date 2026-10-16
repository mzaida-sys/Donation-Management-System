package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Edit_profileController implements Initializable {

    @FXML private TextField nameField, emailField, phoneField;

    private Donor currentDonor;

    public void setDonor(Donor donor) {
        this.currentDonor = donor;
        nameField.setText(donor.getName());
        emailField.setText(donor.getEmail());
        phoneField.setText(donor.getPhone());
    }

    @FXML
    private void saveProfile() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            showAlert("Please fill in all fields.");
        } else {
            currentDonor.setName(name);
            currentDonor.setEmail(email);
            currentDonor.setPhone(phone);
            showAlert("✅ Data saved successfully");
        }
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("donor_main.fxml"));
            Stage stage = (Stage) Stage.getWindows().filtered(Window::isShowing).get(0);
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}