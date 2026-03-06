package test;


public class Position {
    private String StockName;
    private int shares;

    public Position(String StockName, int shares){
        this.StockName = StockName;
        this.shares = shares;
    }

    public String getStockName(){
        return StockName;
    }
    public int getShares() {
        return shares;
    }

    public void addShares(int amount){
        shares += amount;
    }
    public void removeShares(int amount){
        shares -= amount;
    }
}
