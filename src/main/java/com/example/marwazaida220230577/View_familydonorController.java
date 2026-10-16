package com.example.marwazaida220230577;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

public class View_familydonorController implements Initializable {
    @FXML
    private TableView<Family> familyTable;
    @FXML private TableColumn<Family, String> nameCol, addressCol, phoneCol;
    @FXML private TableColumn<Family, Integer> countCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Donor donor = DataStorage.loggedDonor;
        donor.viewFamilies();

        nameCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getName()));
        addressCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getAddress()));
        phoneCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getPhone()));
        countCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getMembersCount()).asObject());

        familyTable.setItems(FXCollections.observableArrayList(DataStorage.families));
    }

    @FXML
    private void handleBack() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/marwazaida220230577/donor_main.fxml"));
        Stage stage = (Stage) Window.getWindows().filtered(Window::isShowing).get(0);
        stage.setScene(new Scene(root));
    }
}