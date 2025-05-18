package com.example.eventmanagement;
import java.time.LocalDate;

public class Attendee extends User {


    //attributes
    private Wallet attendeeWallet = new Wallet();
    private LocalDate dateOfBirth = null;
    private String interests;
    private Gender gender;
    private String address;

    //constructors
    public Attendee() {
        Database.getAttendees().add(this);
    }
    public Attendee(String username, String password) {
        super(username, password);
        Database.getAttendees().add(this);
    }

    public Attendee(String username, String password, int balance, LocalDate dateOfBirth, String interests, String inputGender, String address) {
        super(username, password);
        this.dateOfBirth = dateOfBirth;
        this.interests = interests;
        setGender(inputGender);
        this.getAttendeeWallet().setBalance(balance);
        this.address = address;
        Database.getAttendees().add(this);
    }

    //override toString
    @Override
    public String toString() {
        return "Attendee { " +
                ", attendeeWallet = " + attendeeWallet +
                ", dateOfBirth = " + dateOfBirth +
                ", interests = '" + interests + '\'' +
                ", gender = " + gender +
                ", address = '" + address + '\'' +
                '}';
    }

    //methods
    public void buyTicket ( String chosenEventFromComboBox ) {
        for(Event chosen : Database.getEvents()){
            if(chosenEventFromComboBox.contains(chosen.getEventName())){
                if(this.getAttendeeWallet().isSufficient (chosen.getTicketPrice()))
                {
                    this.getAttendeeWallet().deduct(chosen.getTicketPrice());
                    chosen.getEventOrganizer().getOrganizerWallet().add(chosen.getTicketPrice());
                    chosen.getEventAttendees().add(this);
                    throw new RuntimeException("Successfully purchased. New balance is: " + this.getAttendeeWallet().getBalance());
                }
                else throw new RuntimeException("Balance is insufficient");
            }
        }
    }


    //setters & getters
    public Wallet getAttendeeWallet() {
        return attendeeWallet;
    }

    public void setAttendeeWallet(Wallet attendeeWallet) {
        this.attendeeWallet = attendeeWallet;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String inputGender) {
        this.gender = Gender.valueOf(inputGender.trim().toUpperCase());}

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

