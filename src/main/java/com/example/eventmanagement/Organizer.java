package com.example.eventmanagement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Organizer extends User implements CRUD {

    //attributes
    private Wallet organizerWallet = new Wallet();
    private ArrayList<Event> myEvents = new ArrayList<>();

    //constructors
    public Organizer(){
        Database.getOrganizers().add(this);
    }
    public Organizer(String username, String password) {
        super(username, password);
        Database.getOrganizers().add(this);
    }
    public Organizer(String username, String password, int balance) {
        super(username, password);
        this.getOrganizerWallet().setBalance(balance);
        Database.getOrganizers().add(this);
    }

    //override toString
    @Override
    public String toString() {
       return "Organizer { " +
                "organizerWallet = " + organizerWallet +
               ", myEvents = " + myEvents +
                '}' + "\n";
    }

    //methods
    public ArrayList<String> viewMyAttendees(){
        ArrayList<String> myAttendees = new ArrayList<>();
        for (Event event : myEvents) {
            myAttendees.add("Event Name: " + event.getEventName() + ": ");
            for(Attendee attendee : event.getEventAttendees()){
                myAttendees.add(attendee.getUsername());
            }
        }
        return myAttendees;
    }

    //setters & getters
    public Wallet getOrganizerWallet() {
        return organizerWallet;
    }

    public void setOrganizerWallet(Wallet organizerWallet) {
        this.organizerWallet = organizerWallet;
    }

    public ArrayList<Event> getMyEvents() {
        return myEvents;
    }

    public void setMyEvents(ArrayList<Event> myEvents) {
        this.myEvents = myEvents;
    }

    //event CRUD methods
    public void createEvent(String eventName, Organizer eventOrganizer, LocalDate eventDate, String eventRoomName,String ticketPrice) {
        for(Room room : Database.getRooms()){
           if(room.getRoomNum() == Integer.parseInt(eventRoomName)) {
               if(room.isInBookedDates(eventDate)){
                   throw new RuntimeException("Room is unavailable. Select another date or choose another room");
               }
               new Event(eventName, eventOrganizer, eventDate, room, Integer.parseInt(ticketPrice));
           }
       }

    }

    public void updateEvent(Event oldName, String newEventName, String ticketPrice, String year,String month, String day) {

        if (!(newEventName.isEmpty())){
            oldName.setEventName(newEventName);
        }
        if (!(ticketPrice.isEmpty())){
            oldName.setTicketPrice(Integer.parseInt(ticketPrice));
        }
        if((month != null) && (year != null) && (day != null)){
            if(oldName.getEventRoom().isInBookedDates(LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day)))){
                throw new RuntimeException("Unavailable date. Choose another date.");
            }
            oldName.setEventDate(LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day)));
        }
    }

        public void delete(String name) {
            Event current = new Event();
            for (Event event : Database.getEvents()) {
                if (event.getEventName().equalsIgnoreCase(name)) {
                    current = event;
                    break;
                }
            }
            Database.getEvents().remove(current);
            this.getMyEvents().remove(current);
            current.getEventRoom().getBookedDates().remove(current.getEventDate());
        }
}