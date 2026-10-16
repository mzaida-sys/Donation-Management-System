package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.FileWriter;
import java.io.IOException;

public class DonationHistoryController {

    @FXML private TableView<Donation> historyTable;
    @FXML private TableColumn<Donation, String> dateCol, familyCol, typeCol;
    @FXML private TableColumn<Donation, Number> amountCol;

    @FXML
    public void initialize() {
        dateCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getDate()));
        familyCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getFamily()));
        typeCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getType()));
        amountCol.setCellValueFactory(d -> new javafx.beans.property.SimpleDoubleProperty(d.getValue().getAmount()));

        historyTable.setItems(DataStorage.donations);
        historyTable.refresh();
    }

    @FXML
    private void exportHistory() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Keep a record of donations");
        fileChooser.setInitialFileName("donation_history.txt");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        Stage stage = (Stage) Window.getWindows().filtered(Window::isShowing).get(0);
        java.io.File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Date | Family | Type | Amount\n");
                for (Donation d : DataStorage.donations) {
                    writer.write(d.getDate() + " | " + d.getFamily() + " | " + d.getType() + " | " + d.getAmount() + "\n");
                }
                showAlert("✅ The record has been saved successfully.");
            } catch (IOException e) {
                showAlert("⚠ Save failed: " + e.getMessage());
            }
        } else {
            showAlert("📭 No file selected.");
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
        alert.setTitle("message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}