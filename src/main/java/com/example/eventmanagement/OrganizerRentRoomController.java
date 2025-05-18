package com.example.eventmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.eventmanagement.Main.currentOrganizer;
import static com.example.eventmanagement.Main.setScene;

public class OrganizerRentRoomController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Room room : Database.getRooms()) {
            OrganizerRentRoom.getItems().add(room.toString());
        }
    }

    @FXML
    public Button DeleteButton;
    @FXML
    public Button returnButton;
    @FXML
    public ComboBox<String> OrganizerRentRoom;

    @FXML
    public void OnOrganizerReturnButtonRentRoom(ActionEvent actionEvent) {
        setScene("OrganizerMethods.fxml");
    }
    @FXML
    public void OnOrganizerRentRoom(ActionEvent actionEvent) {

    }
}
