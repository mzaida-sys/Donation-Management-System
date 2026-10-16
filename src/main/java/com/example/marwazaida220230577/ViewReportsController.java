package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ViewReportsController {

    @FXML private Label labelTotalDonations;
    @FXML private Label labelTotalAmount;

    @FXML
    public void initialize() {
        Admin admin = new Admin("admin", "admin");
        admin.viewReports();

        int totalDonations = DataStorage.donations.size();
        double totalAmount = DataStorage.donations.stream()
                .mapToDouble(Donation::getAmount)
                .sum();

        labelTotalDonations.setText("Total Donations: " + totalDonations);
        labelTotalAmount.setText("Total Amount: " + totalAmount + " USD");
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("admin_main.fxml"));
            Stage stage = (Stage) Window.getWindows().filtered(Window::isShowing).get(0);
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}