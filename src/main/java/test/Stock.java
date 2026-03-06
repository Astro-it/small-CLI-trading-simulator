package test;

public class Stock {
    private String StockName;
    private int price;
    private int AvailableShares;

    public Stock(String StockName, int price, int AvailableShares){
        this.StockName = StockName;
        this.price = price;
        this.AvailableShares = AvailableShares;
    }

    public String getStockName() { return StockName;}
    public int getPrice() { return price;}
    public int getAvailableShares() { return AvailableShares;}

    public void reduceAvailableShares(int amount){
        AvailableShares -= amount;
    }
    public void increaseAvailableShares(int amount){
        AvailableShares += amount;
    }
}
