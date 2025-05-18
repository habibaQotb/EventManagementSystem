package com.example.eventmanagement;
import java.time.LocalDate;

public class Admin extends User implements CRUD {

    private LocalDate dateOfBirth = null;
    public String role;
    public int workingHours;


    //constructors
    public Admin() {
        Database.getAdmins().add(this);
        Database.getUsers().add(this);
    }

    public Admin(String username, String password) {
        super(username, password);
        Database.getAdmins().add(this);
        Database.getUsers().add(this);
    }

    public Admin(String inputUsername, String inputPassword, LocalDate dateOfBirth, String role, int workingHours) {

        super(inputUsername, inputPassword);
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.workingHours = workingHours;
        Database.getAdmins().add(this);
        Database.getUsers().add(this);
    }


    //category CRUD methods
    static public void createCategory(String name, String Description) {
            new Category(name, Description);
    }

    public static void updateCategory(String oldName, String newCategoryName, String newCategoryDescription) {
        Category current = new Category();
            for (Category category : Database.getCategories()) {
                if (category.getCategoryName().equalsIgnoreCase(oldName)) {
                    current = category;
                    break;
                }
            }

        if (!(newCategoryName.isEmpty())){
            current.setCategoryName(newCategoryName);
        }
        if (!(newCategoryDescription.isEmpty())){
            current.setCategoryDescription(newCategoryDescription);
        }
    }

    public void delete(String name) {
        Category current = new Category();
        for (Category category : Database.getCategories()) {
            if (category.getCategoryName().equalsIgnoreCase(name)) {
                current = category;
                break;
            }
        }
        Database.getCategories().remove(current);
    }

    //methods
    public static void createRoom(int inputRoomNum) {
        new Room(inputRoomNum);
    }
}