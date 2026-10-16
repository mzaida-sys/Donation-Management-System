package com.example.marwazaida220230577;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ViewEmployeesController {

    @FXML private TableView<Employee> employeeTable;
    @FXML private TableColumn<Employee, String> nameCol;
    @FXML private TableColumn<Employee, String> usernameCol;
    @FXML private TableColumn<Employee, String> birthDateCol;
    @FXML private TableColumn<Employee, String> genderCol;
    @FXML private TableColumn<Employee, String> positionCol;
    @FXML private TableColumn<Employee, String> phoneCol;

    @FXML
    public void initialize() {
        Admin admin = new Admin("admin", "admin");
        admin.addEmployee(new Employee("testUser", "pass", "Test Emp", "01/01/1990", "Male", "Position", "0590000000"));

        nameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getFullName()));
        usernameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getUsername()));
        birthDateCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBirthDate()));
        genderCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getGender()));
        positionCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPosition()));
        phoneCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPhone()));

        employeeTable.setItems(DataStorage.employees);
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("admin_main.fxml"));
            Stage stage = (Stage) employeeTable.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}