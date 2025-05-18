package com.example.eventmanagement;
import java.util.ArrayList;
import java.time.LocalDate;

public class Event {

    //attributes
    private String eventName;//
    private Organizer eventOrganizer = new Organizer();//
    private LocalDate eventDate;//
    private Room eventRoom;//
    private int ticketPrice;//
    private ArrayList<Attendee> eventAttendees = new ArrayList<>();

    //constructors
    public Event(){
        Database.getEvents().add(this);
    }
    public Event(String eventName, Organizer eventOrganizer, LocalDate eventDate, Room eventRoom, int ticketPrice) {
        this.eventName =  eventName ;
        this.eventOrganizer = eventOrganizer;
        this.eventDate = eventDate;
        this.eventRoom = eventRoom;
        this.ticketPrice = ticketPrice;
        Database.getEvents().add(this);
        eventRoom.getBookedDates().add(eventDate);
        eventOrganizer.getMyEvents().add(this);
    }

    //override toString
    @Override
   public String toString() {
       return "Event{" +
                "eventName = '" + eventName + '\'' +
                ", eventOrganizer = " + eventOrganizer.getUsername() +
                ", eventDate = " + eventDate +
                ", eventRoom = " + eventRoom +
                ", ticketPrice = " + ticketPrice +
                ", eventAttendees = " + eventAttendees +
                '}' + "\n";
    }


    //getters & setters
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Organizer getEventOrganizer() {
        return eventOrganizer;
    }

    public void setEventOrganizer(Organizer eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventRoom.getBookedDates().remove(this.eventDate);
        this.eventDate = eventDate;
        this.eventRoom.getBookedDates().add(eventDate);
    }

    public Room getEventRoom() {
        return eventRoom;
    }

    public void setEventRoom(Room eventRoom) {
        this.eventRoom = eventRoom;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public ArrayList<Attendee> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(ArrayList<Attendee> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }
}
