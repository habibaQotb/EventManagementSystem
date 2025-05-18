package com.example.eventmanagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public interface CRUD {

    //methods
    static ObservableList<String> read(ArrayList<Object> list) {
        ObservableList<String> parsedObservable = FXCollections.observableArrayList();
        for (Object elements : list) {
            if(elements != null){
                parsedObservable.add(elements.toString());
            }
        }
        return parsedObservable;
    }

    void delete(String Name);
}
