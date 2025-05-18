package com.example.eventmanagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import static com.example.eventmanagement.Main.setScene;

public class OrganizerSignUpController {
    @FXML
    public TextField OrganizerUsernameTextfieldSignup;
    @FXML
    public TextField OrganizerPasswordTextfieldSignup;
    @FXML
    public TextField OrganizerBalanceTextfield;
    @FXML
    public Button OrganizerSignupButton;
    @FXML
    public Button OrganizerReturnButton;

    @FXML
    public void OnOrganizerUsernameTextfieldSignup(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerPasswordTextfieldSignup(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerBalanceTextfield(ActionEvent actionEvent) {
    }
    @FXML
    public void OnOrganizerReturnButton(ActionEvent actionEvent) {
        setScene("UserDashboard.fxml");
    }
    @FXML
    public void OnOrganizerSignupButton(ActionEvent actionEvent) {

        String inputUsername = OrganizerUsernameTextfieldSignup.getText();
        String inputPassword = OrganizerPasswordTextfieldSignup.getText();
        int balanceTester;

        try {
            if (inputUsername.isEmpty() || inputPassword.isEmpty() || OrganizerBalanceTextfield.getText().isEmpty()) {
                throw new IOException("Fill all fields.");
            }
            if (Verification.isNameDuplicate(inputUsername, new ArrayList<>(Database.getUsers()), "user")) {
                OrganizerUsernameTextfieldSignup.clear();
                throw new IOException("Username already exists. Please choose a different one.");
            }
        }

        catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Signup Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            return;
        }

        try {
            balanceTester = Integer.parseInt(OrganizerBalanceTextfield.getText());
            new Organizer(inputUsername, inputPassword,balanceTester);
            setScene("UserDashboard.fxml");
        }

        catch (Exception ex) {
            OrganizerBalanceTextfield.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Balance");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Balance. Enter integer values.");
            alert.showAndWait();

        }

    }
}
