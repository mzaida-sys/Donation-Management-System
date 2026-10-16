package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class EmployeeController {

    @FXML
    private void handleAddFamily() {
        Employee dummyEmp = new Employee("emp1", "123456", "Dummy Name", "01/01/2000", "Male", "Supervisor", "0591234567");


        System.out.println(dummyEmp.getFullName());
        System.out.println(dummyEmp.getBirthDate());
        System.out.println(dummyEmp.getGender());
        System.out.println(dummyEmp.getPosition());
        System.out.println(dummyEmp.getPhone());
        System.out.println(dummyEmp.getUsername());
        System.out.println(dummyEmp.getPassword());
        System.out.println(dummyEmp.getRole());

        dummyEmp.addFamily(new Family("Dummy Family", 3, "Gaza", "0591234567", "Widow", "Dummy notes"));

        loadScene("add_family.fxml");
    }

    @FXML
    private void handleEditFamily() {
        Employee dummyEmp = new Employee("emp1", "123456", "Dummy Name", "01/01/2000", "Male", "Supervisor", "0591234567");
        if (!DataStorage.families.isEmpty()) {
            dummyEmp.editFamilies(DataStorage.families.get(0), "Updated Address");
        }

        loadScene("edit_family.fxml");
    }

    @FXML
    private void handleViewFamilies2() {
        Employee dummyEmp = new Employee("emp1", "123456", "Dummy Name", "01/01/2000", "Male", "Supervisor", "0591234567");
        dummyEmp.viewFamilies();

        loadScene("view_families2.fxml");
    }

    @FXML
    private void handleLogout() {
        Employee dummyEmp = new Employee("emp1", "123456", "Dummy Name", "01/01/2000", "Male", "Supervisor", "0591234567");
        dummyEmp.logout();

        loadScene("login.fxml");
    }

    private void loadScene(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) Stage.getWindows().filtered(w -> w.isShowing()).get(0);
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}