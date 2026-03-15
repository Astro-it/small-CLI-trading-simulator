package test;
import java.util.ArrayList;
import java.util.Scanner;


public class StockMenu {
    private User user;
    ArrayList<Stock> stocks = new ArrayList<>();

    public StockMenu(User user){
        this.user = user;
    }

    Scanner sc = new Scanner(System.in);
    String BuySell;
    int amount;
    public Position foundPosition = null;
    public PastTrade Trade = null;

    public void BuySellTab(int option){
        while(true){

            System.out.println("Name: " + stocks.get(option - 1).getStockName());
            System.out.println("Price: " + stocks.get(option - 1).getPrice());
            System.out.println("Available shares: " + stocks.get(option - 1).getAvailableShares());
            System.out.println("Buy/Sell");
            System.out.println("0 - Back");
            BuySell = sc.nextLine();

            if(BuySell.equals("0")){
                break;
            }
            if(BuySell.equalsIgnoreCase("Buy")){
                BuyFlow(option);
            } else if(BuySell.equalsIgnoreCase("Sell")){
                SellFlow(option);
            }
        }
    }
    public void BuyFlow(int option){
        String stockName = stocks.get(option - 1).getStockName();
        while(true) {
            System.out.println("you have " + user.getBalance() + "$" + " how many do you want to buy?");
            System.out.println("0 - Back");
            amount = getValidInt(sc);
            sc.nextLine();
            int price = stocks.get(option - 1).getPrice();
            int TotalCost = (price * amount);

            if (TotalCost > user.getBalance() || amount < 0) {
                System.out.println("this transaction cannot be processed");
            } else if (amount == 0) {
                break;
            } else {
                user.withdraw(TotalCost);
                stocks.get(option - 1).reduceAvailableShares(amount);

                for (Position p : user.getPortfolio()) {
                    if (p.getStockName().equals(stockName)) {
                        foundPosition = p;
                        break;
                    }
                }

                if (foundPosition == null) {
                    foundPosition = new Position(stockName, amount);
                    user.getPortfolio().add(foundPosition);
                    System.out.println("You now have " + foundPosition.getShares() + " shares of " + stocks.get(option - 1).getStockName());
                }
                else {
                    foundPosition.addShares(amount);
                    System.out.println("You now have " + foundPosition.getShares() + " shares of " + stocks.get(option - 1).getStockName());
                }
                Trade = new PastTrade(stockName, TotalCost, amount, "bought");
                user.getTradeHistory().add(Trade);

                System.out.println("your balance is " + user.getBalance() + "$");
                foundPosition = null;
                Trade = null;
                break;
            }
        }    
    }
    public void SellFlow(int option){
        String stockName = stocks.get(option - 1).getStockName();
        while(true) {
            for (Position p : user.getPortfolio()) {
                if (p.getStockName().equals(stockName)) {
                    foundPosition = p;
                    break;
                }
            }

            if(foundPosition == null){
                System.out.println("You don't have any shares of this");
                break;
            }
            System.out.println("you have " + foundPosition.getShares() + " of " + foundPosition.getStockName() +" how many do you want to Sell?");
            System.out.println("0 - Back");
            amount = getValidInt(sc);
            sc.nextLine();
            int price = stocks.get(option - 1).getPrice();
            int TotalCost = (price * amount);

            if (amount > foundPosition.getShares() || amount < 0) {
                System.out.println("this transaction cannot be processed");
            } else if (amount == 0) {
                break;
            } else {
                user.deposit(TotalCost);
                stocks.get(option - 1).increaseAvailableShares(amount);

                if (foundPosition != null) {
                    foundPosition.removeShares(amount);
                    System.out.println("You now have " + foundPosition.getShares() + " shares of " + stocks.get(option - 1).getStockName());
                }
                else {
                    System.out.println("you do not have any shares of this!");
                }
                Trade = new PastTrade(stockName, TotalCost, amount, "Sold");
                user.getTradeHistory().add(Trade);

                System.out.println("your balance is " + user.getBalance() + "$");
                foundPosition = null;
                break;
            }
        }
    }

    public void ShowPastTrades(){
        while(true){
            System.out.println("YOUR TRADE HISTORY");
            for(PastTrade trade : user.getTradeHistory()){
                System.out.println(trade);
            }
            System.out.println("0 - back");
            int Option = getValidInt(sc);

            if(Option == 0){break;}
        }
    }

    public static int getValidInt(Scanner sc){

        while (true) {

            System.out.print("Enter a number: ");

            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
    }

    public void menu(){
        stocks.add(new Stock("Gold", 1900, 10000));
        stocks.add(new Stock("NVIDIA", 600, 5000));
        stocks.add(new Stock("AMD", 120, 8000));


        while(true){
            for (int i = 0; i < stocks.size(); i++) {
                System.out.println((i + 1) + " - " + stocks.get(i).getStockName());
            }
            System.out.println(stocks.size() + 1 + " - Trading History");
            System.out.println("0 - Exit");
            System.out.println("type the number of your option");

            int option = getValidInt(sc);
            sc.nextLine();
            if(option == 0){
                break;
            } else if(option == stocks.size() + 1){
                ShowPastTrades();
            } else if(option > stocks.size() || option < 0) {
                System.out.println("this option doesn't exist!");
            } else{
                BuySellTab(option);
            }
        }
    }
}
