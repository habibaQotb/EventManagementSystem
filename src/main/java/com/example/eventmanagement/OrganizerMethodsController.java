package com.example.eventmanagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static com.example.eventmanagement.Main.setScene;
public class OrganizerMethodsController {

    public static String OrganizerDisplayIdentifier;

    @FXML
    public Button OrganizerCreateEventButton;
    @FXML
    public Button OrganizerReadEventButton;
    @FXML
    public Button OrganizerUpdateEventButton;
    @FXML
    public Button OrganizerDeleteEventButton;
    @FXML
    public Button OrganizerDisplayAvailableRoomsButton;
    @FXML
    public Button OrganizerDisplayYourAttendeesButton;
    @FXML
    public Button OrganizerDisplayYourEventsButton;
    @FXML
    public Button OrganizerMethodsReturnButton;
    @FXML
    public void OnOrganizerCreateEventButton(ActionEvent actionEvent) {
        setScene("OrganizerCreateEvent.fxml");
    }
    @FXML
    public void OnOrganizerReadEventButton(ActionEvent actionEvent) {
        OrganizerDisplayIdentifier = "ReadEvent";
        setScene("OrganizerDisplayAll.fxml");
    }
    @FXML
    public void OnOrganizerUpdateEventButton(ActionEvent actionEvent) {
    setScene("OrganizerUpdateEvent.fxml");
    }
    @FXML
    public void OnOrganizerDeleteEventButton(ActionEvent actionEvent) {
        setScene("OrganizerDeleteEvent.fxml");
    }
    @FXML
    public void OnOrganizerDisplayAvailableRoomsButton(ActionEvent actionEvent) {
        OrganizerDisplayIdentifier = "DisplayAvailableRooms";
        setScene("OrganizerDisplayAll.fxml");
    }
    @FXML
    public void OnOrganizerDisplayYourAttendeesButton(ActionEvent actionEvent) {
        OrganizerDisplayIdentifier = "DisplayYourAttendees";
        setScene("OrganizerDisplayAll.fxml");
    }
    @FXML
    public void OnOrganizerDisplayYourEventsButton(ActionEvent actionEvent) {
        OrganizerDisplayIdentifier = "ReadYourEvent";
        setScene("OrganizerDisplayAll.fxml");
    }
    @FXML
    public void OnOrganizerMethodsReturnButton(ActionEvent actionEvent) {
        setScene("UserDashboard.fxml");
    }
}
