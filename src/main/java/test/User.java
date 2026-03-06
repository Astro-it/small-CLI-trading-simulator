package test;
import java.util.ArrayList;


public class User {
    private double balance;
    private ArrayList<Position> portfolio;

    public User(double balance){
        this.balance = balance;
        this.portfolio = new ArrayList<>();
    }

    public double getBalance(){ return balance;}
    public ArrayList<Position> getPortfolio() { return portfolio;}

    public void withdraw(int TotalCost){
        balance -= TotalCost;
    }
    public void deposit(double TotalCost) {
        balance += TotalCost;
    }
}
