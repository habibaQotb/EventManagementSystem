package com.example.eventmanagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;

public class Main extends Application {
    private static Stage mainStage;
    public static String userRole;
    public static Admin currentAdmin;
    public static Organizer currentOrganizer;
    public static Attendee currentAttendee;

    @Override
    public void start(Stage stage) {
        mainStage = stage;
            setScene("dashboard.fxml");
            mainStage.setTitle("Event Management System");
            mainStage.show();
      }


    public static void setScene(String file) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/example/eventmanagement/" + file));
            Parent parent = loader.load();
            mainStage.setScene(new Scene(parent));
            mainStage.sizeToScene();
        } catch (IOException e) {
            showErrorDialog("Scene not found.");
        }
    }

    public static void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Found");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}

