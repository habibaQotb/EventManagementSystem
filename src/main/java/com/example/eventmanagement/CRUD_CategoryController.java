package com.example.eventmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static com.example.eventmanagement.Main.setScene;



public class CRUD_CategoryController implements Initializable {

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(NewCategoryNameTextfield != null && NewCategoryDescriptionTextfield != null){
            NewCategoryNameTextfield.setDisable(true);
            NewCategoryDescriptionTextfield.setDisable(true);
        }
    }


    //create category
    @FXML
    public Button CreateButton;
    @FXML
    public TextField CategoryNameTextfield;
    @FXML
    public TextField CategoryDescriptionTextfield;
    @FXML
    public void OnCategoryNameTextfield(ActionEvent actionEvent) {
    }
    @FXML
    public void OnCategoryDescriptionTextfield(ActionEvent actionEvent) {
    }
    @FXML
    public void OnCreateButton(ActionEvent actionEvent) {

        String inputCategoryName = CategoryNameTextfield.getText();
        String inputCategoryDescription = CategoryDescriptionTextfield.getText();

        try {

            if (inputCategoryName.isEmpty() || inputCategoryDescription.isEmpty()) {
                throw new IOException("Category name and description cannot be empty.");
            }


            if (Verification.isNameDuplicate(inputCategoryName, new ArrayList<>(Database.getCategories()), "category")) {
                CategoryNameTextfield.clear();
                throw new IOException("Category already exists. Please choose a different name.");
            }
            Admin.createCategory(inputCategoryName,inputCategoryDescription);
            setScene("AdminMethods.fxml");

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Creation Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }


    }

    //update category
    @FXML
    public Button UpdateButton;
    @FXML
    public TextField CurrentCategoryNameTextfield;
    @FXML
    public TextField NewCategoryNameTextfield;
    @FXML
    public TextField NewCategoryDescriptionTextfield;


    @FXML
    public void OnCurrentCategoryNameTextfield(ActionEvent actionEvent) {

        String currentCategoryName = CurrentCategoryNameTextfield.getText();
        try {
            if (currentCategoryName.isEmpty()) {
                throw new IOException("You must write the name of the category you want to update.");
            }
            if (!(Verification.isNameDuplicate(currentCategoryName, new ArrayList<>(Database.getCategories()), "category"))) {
                CurrentCategoryNameTextfield.clear();
                throw new IOException("Category name is not found. Enter another name.");
            }
            NewCategoryNameTextfield.setDisable(false);
            NewCategoryDescriptionTextfield.setDisable(false);

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Category name error.");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }


    }
    @FXML
    public void OnNewCategoryNameTextfield(ActionEvent actionEvent) {
    }
    @FXML
    public void OnNewCategoryDescriptionTextfield(ActionEvent actionEvent) {
    }
    @FXML
    public void OnUpdateButton(ActionEvent actionEvent) {
        try{
            if(NewCategoryNameTextfield.isDisabled()){
                CurrentCategoryNameTextfield.clear();
                throw new IOException("Invalid, retype the category name you want to edit.");
            }
        }
        catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Category name error.");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

            Admin.updateCategory(CurrentCategoryNameTextfield.getText(),NewCategoryNameTextfield.getText(), NewCategoryDescriptionTextfield.getText());
            setScene("AdminMethods.fxml");
    }



    //delete category
    @FXML
    public Button DeleteButton;
    @FXML
    public TextField DeleteCategoryTextfield;

    @FXML
    public void OnDeleteCategoryTextfield(ActionEvent actionEvent) {
    }
    @FXML
    public void OnDeleteButton(ActionEvent actionEvent) {

        String categoryName = DeleteCategoryTextfield.getText();

        try {
            if (categoryName.isEmpty()) {
                throw new IOException("Category name cannot be empty.");
            }
            if(!(Verification.isNameDuplicate(categoryName, new ArrayList<>(Database.getCategories()), "category"))){
                DeleteCategoryTextfield.clear();
                throw new IOException("Category not found. Enter an existing category.");
            }

            Admin admin = new Admin();
            admin.delete(categoryName);
            setScene("AdminMethods.fxml");

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }

}


