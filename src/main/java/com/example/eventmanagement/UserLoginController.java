package com.example.eventmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.eventmanagement.Main.setScene;

public class UserLoginController {

    @FXML
    public TextField UserPasswordTextfieldLogin;
    @FXML
    public TextField UsernameTextfieldLogin;
    @FXML
    public Button UserLoginButton;
    @FXML
    public Button UserRETURNButton1;

    @FXML
    public void OnUserPasswordTextfieldLogin(ActionEvent actionEvent) {}
    @FXML
    public void OnUsernameTextfieldLogin(ActionEvent actionEvent) {}
    @FXML
    public void OnUserLoginButton(ActionEvent actionEvent) {

        String LoginUsername = UsernameTextfieldLogin.getText();
        String LoginPassword = UserPasswordTextfieldLogin.getText();
        try {
            if (LoginUsername.isEmpty() || LoginPassword.isEmpty()) {
                throw new IOException("Username and password cannot be empty.");
            }

           boolean verified = true;
            if(Main.userRole.equals("Admin")) {verified = Verification.inputVerifier(LoginUsername, LoginPassword, new ArrayList<>(Database.getAdmins()));}
            if(Main.userRole.equals("Attendee")){verified = Verification.inputVerifier(LoginUsername, LoginPassword, new ArrayList<>(Database.getAttendees()));}
            if(Main.userRole.equals("Organizer")){verified = Verification.inputVerifier(LoginUsername, LoginPassword, new ArrayList<>(Database.getOrganizers()));}

            if (!verified) {
                UsernameTextfieldLogin.clear();
                UserPasswordTextfieldLogin.clear();
                throw new IOException("Incorrect username or incorrect password.");
            }


            //TO GET THE USER OBJECT

            //FIRST IF IT'S AN ADMIN
            if(Main.userRole.equals("Admin")) {
                for(Admin user : Database.getAdmins()){
                    if(user.getUsername().equals(LoginUsername)){
                        Main.currentAdmin = user;
                    }
                }
            }

            //SECOND IF IT'S AN ATTENDEE
            if(Main.userRole.equals("Attendee")){
                for(Attendee user : Database.getAttendees()){
                    if(user.getUsername().equals(LoginUsername)){
                        Main.currentAttendee = user;
                    }
                }
            }

            //IF IT'S AN ORGANIZER
            if(Main.userRole.equals("Organizer")){
                for(Organizer organizer : Database.getOrganizers()){
                    if(organizer != null && organizer.getUsername() != null && organizer.getUsername().equals(LoginUsername)){
                        Main.currentOrganizer = organizer;
                    }
                }
            }
            if(!(Main.userRole.equals("Attendee"))) setScene(Main.userRole + "Methods.fxml");
            else setScene("AttendeeBuyTicket.fxml");

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }
    @FXML
    public void OnUserRETURNButton(ActionEvent actionEvent) {
        setScene("UserDashboard.fxml");
    }
}
