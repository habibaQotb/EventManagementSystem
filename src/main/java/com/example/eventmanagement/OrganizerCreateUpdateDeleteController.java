package com.example.eventmanagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static com.example.eventmanagement.Main.currentOrganizer;
import static com.example.eventmanagement.Main.setScene;

public class OrganizerCreateUpdateDeleteController implements Initializable {

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //update
        if(eventNameTxt != null){
            //year
            for (int year = 2025; year <= 2030; year++) {
                UpdateyearCombo.getItems().add(String.valueOf(year));
            }
            //month
            for (int month = 1; month <= 12; month++) {
                UpdatemonthCombo.getItems().add(String.valueOf(month));
            }
            //day
            for (int day = 1; day <= 30; day++) {
                UpdatedayCombo.getItems().add(String.valueOf(day));
            }

            NEWeventNameTxt1.setDisable(true);
            NEWTicketPriceTxt.setDisable(true);
            UpdatedayCombo.setDisable(true);
            UpdatemonthCombo.setDisable(true);
            UpdateyearCombo.setDisable(true);
        }

        //create
        if(OrganizerCreateEventButton != null){
            //year
            for (int year = 2026; year <= 2030; year++) {
                OrganizerEventYearCBOX.getItems().add(String.valueOf(year));
            }
            //month
            for (int month = 1; month <= 12; month++) {
                OrganizerEventMonthCBOX.getItems().add(String.valueOf(month));
            }
            //day
            for (int day = 1; day <= 30; day++) {
                OrganizerEventDayCBOX.getItems().add(String.valueOf(day));
            }
            //rooms
            for (Room room : Database.getRooms()) {
                OrganizerEventRoomCBOX.getItems().add(String.valueOf(room.getRoomNum()));
            }
            //prices
            for (int price = 50; price <= 2000; price+=50) {
                OrganizerTicketPriceCBOX1.getItems().add(String.valueOf(price));
            }
        }

        //delete
        if(OrganizerDeleteEventCBOX != null){
            for (Event event : Database.getEvents()) {
                OrganizerDeleteEventCBOX.getItems().add(String.valueOf(event.getEventName()));
            }
        }
    }


    //CREATE
    @FXML
    public Button OrganizerCreateEventButton;
    @FXML
    public Button OrganizerCreateEventReturnButton;
    @FXML
    public TextField OrganizerCreateEventNameTextfield;
    @FXML
    public ComboBox<String> OrganizerEventDayCBOX;
    @FXML
    public ComboBox<String> OrganizerEventMonthCBOX;
    @FXML
    public ComboBox<String> OrganizerEventRoomCBOX;
    @FXML
    public ComboBox<String> OrganizerEventYearCBOX;
    @FXML
    public ComboBox<String> OrganizerTicketPriceCBOX1;

    @FXML
    public void OnOrganizerCreateEventButton(ActionEvent actionEvent) {
        try {

            if (OrganizerCreateEventNameTextfield.getText().isEmpty() || OrganizerTicketPriceCBOX1.getValue() == null ||
                    OrganizerEventDayCBOX.getValue() == null || OrganizerEventMonthCBOX.getValue() == null || OrganizerEventRoomCBOX.getValue() == null
                    ||  OrganizerEventYearCBOX.getValue() == null) {
                throw new IOException("Fill all fields.");
            }

            if (Verification.isNameDuplicate(OrganizerCreateEventNameTextfield.getText(), new ArrayList<>(Database.getEvents()), "event")) {
                OrganizerCreateEventNameTextfield.clear();
                throw new IOException("Event already exists. Please choose a different name.");
            }
            currentOrganizer.createEvent(OrganizerCreateEventNameTextfield.getText(), currentOrganizer, LocalDate.of(Integer.parseInt(OrganizerEventYearCBOX.getValue()), Integer.parseInt(OrganizerEventMonthCBOX.getValue()), Integer.parseInt(OrganizerEventDayCBOX.getValue())),
                    OrganizerEventRoomCBOX.getValue(), OrganizerTicketPriceCBOX1.getValue());
            setScene("OrganizerMethods.fxml");
        }
        catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Creation Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    public void OnOrganizerTicketPriceRoomCBOX(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerCreateEventNameTextfield(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerCreateEventReturnButton(ActionEvent actionEvent) {
        setScene("OrganizerMethods.fxml");
    }
    @FXML
    public void OnOrganizerEventDayCBOX(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerEventMonthCBOX(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerEventRoomCBOX(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerEventYearCBOX(ActionEvent actionEvent) {
    }


    //UPDATE
    @FXML
    public Button updateButton;
    @FXML
    public Button returnButton;
    @FXML
    public TextField eventNameTxt;
    @FXML
    public TextField NEWTicketPriceTxt;
    @FXML
    public TextField NEWeventNameTxt1;
    @FXML
    public ComboBox<String> UpdatedayCombo;
    @FXML
    public ComboBox<String> UpdatemonthCombo;
    @FXML
    public ComboBox<String> UpdateyearCombo;


    @FXML
    public void OnOrganizerUpdateButton(ActionEvent actionEvent) {
        try{
            if(NEWeventNameTxt1.isDisabled()){
                eventNameTxt.clear();
                throw new IOException("Invalid, retype the event name you want to edit.");
            }
        }
        catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Event name error.");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            return;
        }

        try{

            boolean found = false;
            for (Event event : Database.getEvents()) {
            if (event.getEventName().equalsIgnoreCase(eventNameTxt.getText())){
                currentOrganizer.updateEvent(event, NEWeventNameTxt1.getText(), NEWTicketPriceTxt.getText(), UpdateyearCombo.getValue(), UpdatemonthCombo.getValue(), UpdatedayCombo.getValue());
                found = true;
                setScene("OrganizerMethods.fxml");
            break;}}
            if(!found){
                throw new RuntimeException("This event doesn't exist.");
            }
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Error.");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void OnOrganizerReturnButton(ActionEvent actionEvent) {
        setScene("OrganizerMethods.fxml");
    }
    @FXML
    public void OnOrganizerEventNameTextfieldUpdateEvent(ActionEvent actionEvent) {

        String currentEventName = eventNameTxt.getText();
        try {
            if (currentEventName.isEmpty()) {
                throw new IOException("You must write the name of the event you want to update.");
            }
            if (!(Verification.isNameDuplicate(currentEventName, new ArrayList<>(Database.getEvents()), "event"))) {
                eventNameTxt.clear();
                throw new IOException("Event name is not found. Enter another name.");
            }
            NEWeventNameTxt1.setDisable(false);
            NEWTicketPriceTxt.setDisable(false);
            UpdatedayCombo.setDisable(false);
            UpdatemonthCombo.setDisable(false);
            UpdateyearCombo.setDisable(false);

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Event name error.");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }
    @FXML
    public void OnOrganizerNewTicketPriceTextfieldUpdateEvent(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerNewEventNameTextfieldUpdateEvent(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerNewDayComboUpdateEvent(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerNewMonthComboUpdateEvent(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerNewYearComboUpdateEvent(ActionEvent actionEvent) {
    }



    //DELETE
    @FXML
    public ComboBox<String> OrganizerDeleteEventCBOX;
    @FXML
    public Button DeleteButton;
    @FXML
    public void OnOrganizerDeleteButton(ActionEvent actionEvent){

        String eventName = OrganizerDeleteEventCBOX.getValue();

        try {
            if (eventName.isEmpty()) {
                throw new IOException("Choose the event.");
            }

            currentOrganizer.delete(eventName);
            setScene("OrganizerMethods.fxml");

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    public void OnOrganizerDeleteEventCBOX(ActionEvent actionEvent) {
    }
}
