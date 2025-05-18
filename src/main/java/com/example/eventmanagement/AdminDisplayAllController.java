package com.example.eventmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static com.example.eventmanagement.AdminMethodsController.adminDisplayIdentifier;
import static com.example.eventmanagement.Main.setScene;

public class AdminDisplayAllController implements Initializable {

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (adminDisplayIdentifier.equals("Categories")) {
            for(String string : CRUD.read(new ArrayList<>(Database.getCategories()))){
                if(string != null) DisplayAllList.getItems().add(string);
            }

        }
        if (adminDisplayIdentifier.equals("Rooms")) {
            for(String string : CRUD.read(new ArrayList<>(Database.getRooms()))){
                if(string != null)  DisplayAllList.getItems().add(string);
            }
        }
        if (adminDisplayIdentifier.equals("Attendees")) {
            for(String string : CRUD.read(new ArrayList<>(Database.getAttendees()))){
                if(string != null)  DisplayAllList.getItems().add(string);
            }
        }
        if (adminDisplayIdentifier.equals("Events")) {
            for(String string : CRUD.read(new ArrayList<>(Database.getEvents()))){
                if(string != null)  DisplayAllList.getItems().add(string);
            }
        }
    }


    @FXML
    public Button DisplayAllReturnButton;
    @FXML
    public ListView<String> DisplayAllList;
    @FXML
    public void OnCategoryReadReturnButton(ActionEvent actionEvent) {
        setScene("AdminMethods.fxml");
    }


}
