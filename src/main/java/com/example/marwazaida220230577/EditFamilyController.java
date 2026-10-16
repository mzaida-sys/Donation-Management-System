package com.example.marwazaida220230577;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EditFamilyController {

    @FXML private TableView<Family> familyTable;
    @FXML private TableColumn<Family, String> nameCol;
    @FXML private TableColumn<Family, Number> membersCol;
    @FXML private TableColumn<Family, String> addressCol;
    @FXML private TableColumn<Family, String> phoneCol;
    @FXML private TableColumn<Family, String> statusCol;
    @FXML private TableColumn<Family, String> notesCol;

    @FXML private TextField nameField;
    @FXML private TextField membersField;
    @FXML private TextField addressField;
    @FXML private TextField phoneField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private TextField notesField;
    @FXML private Label statusLabel;

    private Family selectedFamily;

    @FXML
    public void initialize() {

        nameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
        membersCol.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getMembersCount()));
        addressCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAddress()));
        phoneCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPhone()));
        statusCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getStatus()));
        notesCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNotes()));

        familyTable.setItems(DataStorage.families);

        statusComboBox.getItems().addAll("widowed", "divorced", "married", "single", "other");

        familyTable.getSelectionModel().selectedItemProperty().addListener((obs, old, selected) -> {
            if (selected != null) {
                selectedFamily = selected;
                nameField.setText(selected.getName());
                membersField.setText(String.valueOf(selected.getMembersCount()));
                addressField.setText(selected.getAddress());
                phoneField.setText(selected.getPhone());
                statusComboBox.setValue(selected.getStatus());
                notesField.setText(selected.getNotes());
                statusLabel.setText("");
                statusLabel.setStyle("-fx-text-fill: black;");
            }
        });
    }

    @FXML
    private void handleUpdate() {
        if (selectedFamily == null) {
            statusLabel.setText("Please select a family to edit.");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        try {
            String name = nameField.getText().trim();
            int members = Integer.parseInt(membersField.getText().trim());
            String address = addressField.getText().trim();
            String phone = phoneField.getText().trim();
            String status = statusComboBox.getValue();
            String notes = notesField.getText().trim();

            if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || status == null) {
                statusLabel.setText("All fields are required.");
                statusLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            if (!phone.matches("05\\d{8}")) {
                statusLabel.setText("The phone number must start with 05 and consist of 10 digits.");
                statusLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            selectedFamily.setName(name);
            selectedFamily.setMembersCount(members);
            selectedFamily.setAddress(address);
            selectedFamily.setPhone(phone);
            selectedFamily.setStatus(status);
            selectedFamily.setNotes(notes);

            familyTable.refresh();

            statusLabel.setText("Family data has been modified successfully.");
            statusLabel.setStyle("-fx-text-fill: green;");
        } catch (NumberFormatException e) {
            statusLabel.setText("The number of people must be an integer.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("employee_main.fxml"));
            Stage stage = (Stage) familyTable.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}