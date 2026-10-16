package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        try {
            if (username.equals("admin") && password.equals("admin")) {
                loadScene("admin_main.fxml");
            } else if (username.equals("employee1") && password.equals("123456")) {
                loadScene("employee_main.fxml");
            } else if (username.equals("employee2") && password.equals("123456")) {
                loadScene("employee_main.fxml");
            } else if (username.equals("donor1") && password.equals("123456")) {

                loadScene("donor_main.fxml");
            } else {
                errorLabel.setText("Invalid login. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Error loading screen.");
        }
    }

    private void loadScene(String fxmlPath) throws Exception {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}



