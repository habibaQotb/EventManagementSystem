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

public class AdminSignUpController implements Initializable {

    @FXML
    public ComboBox<String> AdminYear;
    @FXML
    public Button AdminSignupButton;
    @FXML
    public ComboBox<String> AdminDay;
    @FXML
    public TextField AdminUsernameTextfieldSignup;
    @FXML
    public TextField AdminPasswordTextfieldSignup;
    @FXML
    public ComboBox<String> AdminMonth;
    @FXML
    public ComboBox<String> AdminWorkingHrs;
    @FXML
    public Button AdminRETURNButton1;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //year
        for (int year = 1950; year <= 2006; year++) {
            AdminYear.getItems().add(String.valueOf(year));
        }
        //month
        for (int month = 1; month <= 12; month++) {
            AdminMonth.getItems().add(String.valueOf(month));
        }
        //day
        for (int day = 1; day <= 30; day++) {
            AdminDay.getItems().add(String.valueOf(day));
        }
        //working hrs
        for (int hrs = 1; hrs <= 12; hrs++) {
            AdminWorkingHrs.getItems().add(String.valueOf(hrs));
        }
    }


    @FXML
    public void OnAdminYear(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAdminDay(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAdminPasswordTextfieldSignup(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAdminUsernameTextfieldSignup(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAdminMonth(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAdminWorkingHrs(ActionEvent actionEvent) {
    }
    @FXML
    public void OnAdminSignupButton(ActionEvent actionEvent) {
        String inputUsername = AdminUsernameTextfieldSignup.getText();
        String inputPassword = AdminPasswordTextfieldSignup.getText();
        String inputYear = AdminYear.getValue();
        String inputMonth = AdminMonth.getValue();
        String inputDay = AdminDay.getValue();
        String inputWorkingHrs = AdminWorkingHrs.getValue();

        try {

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                throw new IOException("Username and password cannot be empty.");
            }

            if (inputYear == null || inputMonth == null || inputDay == null || inputWorkingHrs == null) {
                throw new IOException("Please select all date and working hour fields.");
            }

            if (Verification.isNameDuplicate(inputUsername, new ArrayList<>(Database.getUsers()), "user")) {
                AdminUsernameTextfieldSignup.clear();
                throw new IOException("Username already exists. Please choose a different one.");
            }

            LocalDate dob = LocalDate.of(Integer.parseInt(inputYear),Integer.parseInt(inputMonth),Integer.parseInt(inputDay));
            new Admin(inputUsername, inputPassword, dob, "Admin", Integer.parseInt(inputWorkingHrs));
            setScene("UserDashboard.fxml");

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Signup Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    public void OnAdminRETURNButton(ActionEvent actionEvent) {
        setScene("UserDashboard.fxml");
    }
}
