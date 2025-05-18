package com.example.eventmanagement;
import java.util.ArrayList;
public class Verification {


    // for login method -> we enter the current password, and it checks if it's correct
    public static boolean inputVerifier(String inputUserName, String inputPassword, ArrayList<User> allUsers) {
        boolean found = false;
        for (User currentUser : allUsers) {
            if (currentUser.getUsername().equals(inputUserName) && currentUser.getPassword().equals(inputPassword)) {
                found = true;
                currentUser.login();
                break;
            }
        }
        return found;
    }

    // for setting unique names -> we enter the name, and it checks if it is duplicate
    public static boolean isNameDuplicate(String inputName, ArrayList<Object> objects, String classType) {
        for (Object obj : objects) {
            switch (classType.toLowerCase()) {
                case "event": {
                    if (obj instanceof Event) {
                        if (inputName.equalsIgnoreCase(((Event) obj).getEventName())) return true;
                    }
                    break;
                }

                case "category": {
                    if (obj instanceof Category) {
                        if (inputName.equalsIgnoreCase(((Category) obj).getCategoryName())) return true;
                    }
                    break;
                }
                case "room": {
                    if (obj instanceof Room) {
                        if (inputName.equalsIgnoreCase(String.valueOf(((Room) obj).getRoomNum()))) return true;

                    }
                    break;
                }
                case "user": {
                    if (obj instanceof User) {
                        if (inputName.equalsIgnoreCase(((User) obj).getUsername())) return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

}