package com.example.marwazaida220230577;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ViewFamilies2Controller {

    @FXML private TableView<Family> familyTable;
    @FXML private TableColumn<Family, String> nameCol;
    @FXML private TableColumn<Family, Number> membersCol;
    @FXML private TableColumn<Family, String> addressCol;
    @FXML private TableColumn<Family, String> phoneCol;
    @FXML private TableColumn<Family, String> statusCol;
    @FXML private TableColumn<Family, String> notesCol;

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
        membersCol.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getMembersCount()));
        addressCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAddress()));
        phoneCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPhone()));
        statusCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getStatus()));
        notesCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNotes()));

        familyTable.setItems(DataStorage.families);
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