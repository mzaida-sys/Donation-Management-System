package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddFamilyController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField membersField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private ComboBox<String> statusComboBox;
    @FXML
    private TextArea notesArea;
    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        statusComboBox.getItems().addAll("widow", "divorced", "married", "Single", "Other");
    }

    @FXML
    private void handleAddFamily() {
        String name = nameField.getText().trim();
        String membersStr = membersField.getText().trim();
        String address = addressField.getText().trim();
        String phone = phoneField.getText().trim();
        String status = statusComboBox.getValue();
        String notes = notesArea.getText().trim();

        if (name.isEmpty() || membersStr.isEmpty() || address.isEmpty() || phone.isEmpty() || status == null) {
            statusLabel.setText("Please fill all fields.");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!phone.matches("05\\d{8}")) {
            statusLabel.setText("Phone must start with 05 and be 10 digits.");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        try {
            int membersCount = Integer.parseInt(membersStr);

            Family family = new Family(name, membersCount, address, phone, status, notes);
            DataStorage.families.add(family);

            statusLabel.setText("Family added successfully.");
            statusLabel.setStyle("-fx-text-fill: green;");

            nameField.clear();
            membersField.clear();
            addressField.clear();
            phoneField.clear();
            statusComboBox.getSelectionModel().clearSelection();
            notesArea.clear();

        } catch (NumberFormatException e) {
            statusLabel.setText("Members count must be a number.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("employee_main.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}