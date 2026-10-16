package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {

    @FXML private TextField fullNameField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private DatePicker birthDatePicker;
    @FXML private RadioButton maleRadio;
    @FXML private RadioButton femaleRadio;
    @FXML private ComboBox<String> positionComboBox;
    @FXML private TextField phoneField;
    @FXML private Label statusLabel;

    private ToggleGroup genderGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);

        positionComboBox.getItems().addAll("Field Worker", "Supervisor");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        birthDatePicker.setConverter(new javafx.util.StringConverter<>() {
            @Override
            public String toString(java.time.LocalDate date) {
                return (date != null) ? formatter.format(date) : "";
            }

            @Override
            public java.time.LocalDate fromString(String string) {
                if (string == null || string.trim().isEmpty()) {
                    return null;
                }
                return java.time.LocalDate.parse(string, formatter);
            }
        });

        birthDatePicker.setPromptText("dd/MM/yyyy");
    }

    @FXML
    private void handleAddEmployee() {
        String fullName = fullNameField.getText().trim();
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        String birthDate = "";
        if (birthDatePicker.getValue() != null)
            birthDate = birthDatePicker.getValue().toString();

        String gender = "";
        if (maleRadio.isSelected()) {
            gender = "Male";
        } else if (femaleRadio.isSelected()) {
            gender = "Female";
        }

        String position = positionComboBox.getValue();
        String phone = phoneField.getText().trim();

        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() ||
                birthDate.isEmpty() || gender.isEmpty() || position == null || phone.isEmpty()) {

            statusLabel.setText("Please fill all fields.");
            statusLabel.setTextFill(Color.RED);
            return;
        }

        if (!phone.matches("05\\d{8}")) {
            statusLabel.setText("Phone must start with 05 and be 10 digits.");
            statusLabel.setTextFill(Color.RED);
            return;
        }

        Employee emp = new Employee(username, password, fullName, birthDate, gender, position, phone);
        DataStorage.employees.add(emp);

        statusLabel.setText("Employee added successfully!");
        statusLabel.setTextFill(Color.GREEN);

        fullNameField.clear();
        usernameField.clear();
        passwordField.clear();
        birthDatePicker.setValue(null);
        genderGroup.selectToggle(null);
        positionComboBox.getSelectionModel().clearSelection();
        phoneField.clear();
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("admin_main.fxml"));
            Stage stage = (Stage) fullNameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}