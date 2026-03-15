package test;

public class PastTrade {
    private String StockName;
    private int price;
    private int BoughtShares;
    private String SoldBought;

    public PastTrade(String StockName, int price, int BoughtShares, String SoldBought){
        this.StockName = StockName;
        this.price = price;
        this.BoughtShares = BoughtShares;
        this.SoldBought = SoldBought;
    }

    @Override
    public String toString() {
        return "Stock: " + StockName +
                " | Price: " + price +
                " | Amount: " +  BoughtShares +
                " | Order Type: " + SoldBought;

    }

    public String getStockName(){return StockName;}
    public String getSoldBought() {return SoldBought;}
    public int getPrice() {return price;}
    public int getBoughtShares() {return BoughtShares;}

}
