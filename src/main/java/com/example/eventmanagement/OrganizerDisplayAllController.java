package com.example.eventmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static com.example.eventmanagement.Main.currentOrganizer;
import static com.example.eventmanagement.Main.setScene;
import static com.example.eventmanagement.OrganizerMethodsController.OrganizerDisplayIdentifier;

public class OrganizerDisplayAllController implements Initializable {
    @FXML
    public Button OrganizerEventsReturn;
    @FXML
    public ListView<String> AllEventListView;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (OrganizerDisplayIdentifier.equals("ReadEvent")) {
            for(String string : CRUD.read(new ArrayList<>(Database.getEvents()))){
                if(string != null) AllEventListView.getItems().add(string);
            }
        }

        if (OrganizerDisplayIdentifier.equals("DisplayAvailableRooms")) {
            for(String string : CRUD.read(new ArrayList<>(Database.getRooms()))){
                if(string != null) AllEventListView.getItems().add(string);
            }
        }

        if (OrganizerDisplayIdentifier.equals("DisplayYourAttendees")) {
            for(String string : CRUD.read(new ArrayList<>(currentOrganizer.viewMyAttendees()))){
                if(string != null) AllEventListView.getItems().add(string);
            }
        }

        if (OrganizerDisplayIdentifier.equals("ReadYourEvent")) {
            for(String string : CRUD.read(new ArrayList<>(currentOrganizer.getMyEvents()))){
                if(string != null) AllEventListView.getItems().add(string);
            }
        }
    }

    @FXML
    public void OnOrganizeSrReturnButton(ActionEvent actionEvent) {
        setScene("OrganizerMethods.fxml");
    }
}
