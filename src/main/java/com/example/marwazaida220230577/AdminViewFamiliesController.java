package com.example.marwazaida220230577;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AdminViewFamiliesController {

    @FXML private TableView<Family> familyTable;
    @FXML private TableColumn<Family, String> nameColumn;
    @FXML private TableColumn<Family, Integer> membersColumn;
    @FXML private TableColumn<Family, String> addressColumn;
    @FXML private TableColumn<Family, String> phoneColumn;
    @FXML private TableColumn<Family, String> statusColumn;
    @FXML private TableColumn<Family, String> notesColumn;

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        membersColumn.setCellValueFactory(new PropertyValueFactory<>("membersCount"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));

        familyTable.setItems(DataStorage.families);
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