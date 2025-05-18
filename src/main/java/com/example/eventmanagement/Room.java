package com.example.eventmanagement;
import java.time.LocalDate;
import java.util.ArrayList;

    public class Room {

    //attributes
    private int roomNum;
    private ArrayList<LocalDate> bookedDates = new ArrayList<>();

    //constructors
    public Room() {
        Database.getRooms().add(this);
    }

    public Room(int inputRoomNum){
        roomNum = inputRoomNum;
        Database.getRooms().add(this);
    }

    //override toString
    @Override
    public String toString() {
        return "Room { " +
                "roomNum = " + roomNum +
                ", bookedDates = " + bookedDates +
                '}';
    }

    //methods
    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
         this.roomNum = roomNum;
    }

    public ArrayList<LocalDate> getBookedDates() {
        return bookedDates;
    }

    public void removePastDates(ArrayList<LocalDate> dates) {
        LocalDate today = LocalDate.now();
        dates.removeIf(date -> date.isBefore(today));
    }

    public boolean isInBookedDates(LocalDate date){
        removePastDates(this.getBookedDates());
            return bookedDates.contains(date);
    }
}
