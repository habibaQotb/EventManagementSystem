package com.example.eventmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static com.example.eventmanagement.Main.setScene;

public class AdminMethodsController {

    public static String adminDisplayIdentifier;

    @FXML
    public Button AdminCreateCategoryButton;
    @FXML
    public Button AdminReadCategoryButton;
    @FXML
    public Button AdminUpdateCategoryButton;
    @FXML
    public Button AdminDeleteCategoryButton;
    @FXML
    public Button AdminAddRoomButton;
    @FXML
    public Button AdminDisplayRoomsButton;
    @FXML
    public Button AdminDisplayAttendeesButton;
    @FXML
    public Button AdminDisplayEventsButton;
    @FXML
    public Button AdminMethodsReturnButton;


    @FXML //yes
    public void OnAdminCreateCategoryButton(ActionEvent actionEvent) {
        setScene("CreateCategory.fxml");
    }
    @FXML //yes
    public void OnAdminReadCategoryButton(ActionEvent actionEvent) {
        adminDisplayIdentifier = "Categories";
        setScene("AdminDisplayAll.fxml");
    }
    @FXML //yes
    public void OnAdminUpdateCategoryButton(ActionEvent actionEvent) {
        setScene("UpdateCategory.fxml");
    }
    @FXML //yes
    public void OnAdminDeleteCategoryButton(ActionEvent actionEvent) {
        setScene("DeleteCategory.fxml");
    }
    @FXML
    public void OnAdminAddRoomButton(ActionEvent actionEvent) {
        setScene("AdminAddRoom.fxml");
    }
    @FXML
    public void OnAdminDisplayRoomsButton(ActionEvent actionEvent) {
        adminDisplayIdentifier = "Rooms";
        setScene("AdminDisplayAll.fxml");
    }
    @FXML
    public void OnAdminDisplayAttendeesButton(ActionEvent actionEvent) {

        adminDisplayIdentifier = "Attendees";
        setScene("AdminDisplayAll.fxml");
    }
    @FXML
    public void OnAdminDisplayEventsButton(ActionEvent actionEvent) {
        adminDisplayIdentifier = "Events";
        setScene("AdminDisplayAll.fxml");
    }
    @FXML
    public void OnAdminMethodsReturnButton(ActionEvent actionEvent) {
        setScene("UserDashboard.fxml");
    }
}
