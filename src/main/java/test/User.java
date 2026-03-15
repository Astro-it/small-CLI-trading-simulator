package test;
import java.util.ArrayList;


public class User {
    private double balance;
    private ArrayList<Position> portfolio;
    private ArrayList<PastTrade> TradeHistory;

    public User(double balance){
        this.balance = balance;
        this.portfolio = new ArrayList<>();
        this.TradeHistory = new ArrayList<>();
    }

    public double getBalance(){ return balance;}
    public ArrayList<Position> getPortfolio() { return portfolio;}
    public ArrayList<PastTrade> getTradeHistory() { return TradeHistory;}

    public void withdraw(int TotalCost){
        balance -= TotalCost;
    }
    public void deposit(double TotalCost) {
        balance += TotalCost;
    }
}
