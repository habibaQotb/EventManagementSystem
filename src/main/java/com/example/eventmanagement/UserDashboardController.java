package com.example.eventmanagement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import static com.example.eventmanagement.Main.setScene;

public class UserDashboardController {
    @FXML
    public Button UserSignupButton;

    @FXML
    public Button UserLoginButton;

    @FXML
    public Button UserReturnButton;


    @FXML
    protected void OnUserSignupButton() throws IOException {
        setScene( Main.userRole + "SignUp.fxml");
    }

    @FXML
    protected void OnUserLoginButton() throws IOException {
        setScene("UserLogin.fxml");
    }

    @FXML
    protected void OnUserReturnButton() throws IOException {
        setScene("dashboard.fxml");
    }
}
