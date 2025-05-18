package com.example.eventmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.eventmanagement.Main.setScene;

public class AttendeeSignUpController implements Initializable {

    @FXML
    public TextField AttendeeUsernameTextfieldSignup;
    @FXML
    public TextField AttendeePasswordTextfieldSignup;
    @FXML
    public ComboBox<String> AttendeeDay;
    @FXML
    public ComboBox<String> AttendeeMonth;
    @FXML
    public ComboBox<String> AttendeeYear;
    @FXML
    public RadioButton AttendeeMaleRadioButton;
    @FXML
    public RadioButton AttendeeFemaleRadioButton;
    @FXML
    public TextField AttendeeBalanceTextfieldSignup;
    @FXML
    public TextField AttendeeInterestsTextfieldSignup;
    @FXML
    public TextField AttendeeAddressTextfieldSignup;
    @FXML
    public Button AttendeeRegisterButton;
    @FXML
    public Button AttendeeRETURNButton1;
    ToggleGroup genderGroup = new ToggleGroup();

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //year
        for (int year = 1950; year <= 2006; year++) {
            AttendeeYear.getItems().add(String.valueOf(year));
        }
        //month
        for (int month = 1; month <= 12; month++) {
            AttendeeMonth.getItems().add(String.valueOf(month));
        }
        //day
        for (int day = 1; day <= 30; day++) {
            AttendeeDay.getItems().add(String.valueOf(day));
        }
        //gender
        AttendeeMaleRadioButton.setToggleGroup(genderGroup);
        AttendeeFemaleRadioButton.setToggleGroup(genderGroup);
    }

    @FXML
    public void OnAttendeeRegisterButton(ActionEvent actionEvent) {
        String inputUsername = AttendeeUsernameTextfieldSignup.getText();
        String inputPassword = AttendeePasswordTextfieldSignup.getText();
        String inputYear = AttendeeYear.getValue();
        String inputMonth = AttendeeMonth.getValue();
        String inputDay = AttendeeDay.getValue();
        String inputInterests = AttendeeInterestsTextfieldSignup.getText();
        String inputAddress = AttendeeAddressTextfieldSignup.getText();
        int balanceTester;
        LocalDate dob;
        String inputGender;

        try {

            if (inputUsername.isEmpty() || inputPassword.isEmpty() || inputInterests.isEmpty() || inputAddress.isEmpty() || AttendeeBalanceTextfieldSignup.getText().isEmpty()) {
                throw new IOException("Fill all fields.");
            }

            if (inputYear == null || inputMonth == null || inputDay == null || genderGroup.getSelectedToggle().toString() == null ) {
                throw new IOException("Fill all fields.");
            }

            if (Verification.isNameDuplicate(inputUsername, new ArrayList<>(Database.getUsers()), "user")) {
                AttendeeUsernameTextfieldSignup.clear();
                throw new IOException("Username already exists. Please choose a different one.");
            }
            dob = LocalDate.of(Integer.parseInt(inputYear),Integer.parseInt(inputMonth),Integer.parseInt(inputDay));
            RadioButton choice = (RadioButton)genderGroup.getSelectedToggle();
            inputGender = choice.getText();

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Signup Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            return;
        }

        try {
            balanceTester = Integer.parseInt(AttendeeBalanceTextfieldSignup.getText());
            new Attendee(inputUsername, inputPassword, balanceTester, dob, inputInterests, inputGender, inputAddress);
            setScene("UserDashboard.fxml");
        }

        catch (Exception ex) {
            AttendeeBalanceTextfieldSignup.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Balance");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Balance. Enter integer values." + inputGender + ".");
            alert.showAndWait();
        }
    }

    @FXML
    public void OnAttendeeUsernameTextfieldSignup(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeePasswordTextfieldSignup(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeDay(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeMonth(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeYear(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeMaleRadioButton(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeFemaleRadioButton(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeBalanceTextfieldSignup(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeInterestsTextfieldSignup(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeAddressTextfieldSignup(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAttendeeRETURNButton(ActionEvent actionEvent) {
        setScene("UserDashboard.fxml");
    }
}
