package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

public class DonorController implements Initializable {

    @FXML
    private void openEditProfile() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("edit_profile.fxml"));
            Parent root = loader.load();

            Edit_profileController controller = loader.getController();
            controller.setDonor(DataStorage.loggedDonor);

            Stage stage = (Stage) Window.getWindows().filtered(Window::isShowing).get(0);
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("An error occurred while loading the screen.");
        }
    }

    @FXML
    private void openViewFamilies() {

        DataStorage.loggedDonor.viewFamilies();
        loadFXML("donor_view_families.fxml");
    }

    @FXML
    private void openMakeDonation() {
        loadFXML("make_donation.fxml");
    }

    @FXML
    private void openDonationHistory() {

        DataStorage.loggedDonor.viewDonations();
        loadFXML("donation_history.fxml");
    }

    @FXML
    private void handleLogout() {
        DataStorage.loggedDonor.logout();
        loadFXML("login.fxml");
    }

    private void loadFXML(String fileName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/marwazaida220230577/" + fileName));
            Stage stage = (Stage) Window.getWindows().filtered(Window::isShowing).get(0);
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("An error occurred while loading the screen.");
        }
    }

    private void showAlert(String msg) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}