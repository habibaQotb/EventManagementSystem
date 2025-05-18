package com.example.eventmanagement;
import java.util.ArrayList;

public abstract class Database {

    //attributes
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Organizer> organizers = new ArrayList<>();
    private static ArrayList<Attendee> attendees = new ArrayList<>();
    private static ArrayList<Event> events = new ArrayList<>();
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Category> categories = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();

    //methods
    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public static ArrayList<Attendee> getAttendees() {
        return attendees;
    }

    public static ArrayList<Organizer> getOrganizers() {
        return organizers;
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
