package com.example.eventmanagement;
//UML
//relation between event/category
//wallet (relation between classes)
//check code logic


public abstract class User {

    //attributes
    private String username;
    private String password;
    public boolean isLoggedIn = false;

    //constructors
    protected User(){
        Database.getUsers().add(this);
    }
    protected User(String username, String password){
        this.username = username;
        this.password = password;
        Database.getUsers().add(this);
    }

    //methods
    public String getUsername(){return username;}
    public String getPassword() {
        return password;
    }
    public void login(){
            isLoggedIn = true;
    }
    public void logout(){
        if(isLoggedIn)
            isLoggedIn = false;
    }

}