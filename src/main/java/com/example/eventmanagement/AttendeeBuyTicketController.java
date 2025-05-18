package com.example.eventmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.eventmanagement.Main.setScene;

public class AttendeeBuyTicketController implements Initializable {

    @FXML
    public ComboBox<String> AttendeeDisplayEventsComboBox;
    @FXML
    public Button AttendeeBuyTicketConfirmButton;
    @FXML
    public Button ReturnToUserDashboardButton;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Event event : Database.getEvents()) {
            if(event != null) AttendeeDisplayEventsComboBox.getItems().add(event.toString());
        }
    }

    @FXML
    public void OnAttendeeDisplayEventsComboBox(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeBuyTicketConfirmButton(ActionEvent actionEvent) {

        String chosenEventFromComboBox = AttendeeDisplayEventsComboBox.getValue();
        try {
            if (chosenEventFromComboBox == null) {
                throw new IOException("Choose an event to buy its ticket.");
            }

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Buy Ticket Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            return;
        }
        try{
            Main.currentAttendee.buyTicket(chosenEventFromComboBox);
        }
       catch(Exception ex){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Message from Buy Ticket");
           alert.setHeaderText(null);
           alert.setContentText(ex.getMessage());
           alert.showAndWait();
       }
    }
    @FXML
    public void OnReturnToUserDashboardButton(ActionEvent actionEvent) {
        setScene("UserDashboard.fxml");
    }
}
