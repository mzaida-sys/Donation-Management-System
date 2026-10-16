package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class AdminController {

    private Admin admin = new Admin( "admin", "1234");

    private void loadScene(String fxmlPath) {
        try {
            Stage stage = (Stage) Stage.getWindows().filtered(w -> w.isShowing()).get(0);
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddEmployee() {
        admin.addEmployee(new Employee("ahmedUser", "123456", "Dummy", "01/01/1990", "Male", "Position", "0595860400"));
        loadScene("add_employee.fxml");
    }

    @FXML
    private void handleViewEmployees() {
        loadScene("view_employees.fxml");
    }

    @FXML
    private void handleViewFamilies() {
        loadScene("admin_view_families.fxml");
    }

    @FXML
    private void handleViewReports() {
        admin.viewReports();
        loadScene("view_reports.fxml");
    }

    @FXML
    private void handleLogout() {
        admin.logout();
        loadScene("login.fxml");
    }
}