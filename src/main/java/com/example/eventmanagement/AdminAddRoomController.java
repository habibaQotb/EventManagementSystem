package com.example.eventmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import static com.example.eventmanagement.Main.setScene;

public class AdminAddRoomController {

    @FXML
    public TextField roomNumberTextfield;
    @FXML
    public Button newRoomCreateButton;
    @FXML
    public Button newRoomReturnButton;

    @FXML
    public void OnRoomNumberTextfield(ActionEvent actionEvent) {
    }
    @FXML
    public void OnNewRoomCreateButton(ActionEvent actionEvent) {

        try {
            int roomNumber = Integer.parseInt(roomNumberTextfield.getText());
        }

        catch (Exception ex) {
        roomNumberTextfield.clear();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Room Number");
        alert.setHeaderText(null);
        alert.setContentText("Invalid Room Number Enter another one");
        alert.showAndWait();
        return;
        }

        String roomNum = roomNumberTextfield.getText();
        try {
            if (roomNum.isEmpty()) {
                throw new IOException("room number - id - cannot be empty.");
            }
            if (Verification.isNameDuplicate(roomNum, new ArrayList<>(Database.getRooms()), "room")) {
                roomNumberTextfield.clear();
                throw new IOException("room number is repeated. Enter another room");
            }
            Admin.createRoom(Integer.parseInt(roomNum));
            setScene("AdminMethods.fxml");
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Room addition number");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
       @FXML
       public void OnNewRoomReturnButton(ActionEvent actionEvent) {
           setScene("AdminMethods.fxml");
       }
    }


