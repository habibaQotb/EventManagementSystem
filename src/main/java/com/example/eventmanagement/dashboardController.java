package com.example.eventmanagement;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import static com.example.eventmanagement.Main.setScene;

public class dashboardController  {
    @FXML
    public Button WelcomeAdminButton;

    @FXML
    public Button WelcomeOrganizerButton;

    @FXML
    public Button WelcomeAttendeeButton;


    @FXML
    protected void OnWelcomeAdminButton() throws IOException {
        Main.userRole = "Admin";
        setScene("UserDashboard.fxml");
    }

    @FXML
    protected void OnWelcomeOrganizerButton() throws IOException {
        Main.userRole = "Organizer";
        setScene("UserDashboard.fxml");
    }

    @FXML
    protected void OnWelcomeAttendeeButton() throws IOException {
        Main.userRole = "Attendee";
        setScene("UserDashboard.fxml");
    }

}

