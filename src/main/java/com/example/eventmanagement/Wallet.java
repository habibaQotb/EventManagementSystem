package com.example.eventmanagement;

public class Wallet {
private int balance;

public Wallet (int balance){
    this.balance= balance;
}
public Wallet(){}

    @Override
    public String toString() {
        return "Wallet{" +
                "balance=" + balance +
                '}';
    }

    public void setBalance(int newBalance){
    this.balance= newBalance;
}
public int getBalance() {
    return balance;
}
public void add(int amount){
    balance = balance + amount ;
}

public void deduct (int amount){
    balance = balance - amount;

}
public boolean isSufficient (int amount){
    return amount <= balance;
}

}

