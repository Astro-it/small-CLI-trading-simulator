package test;

public class Stock {
    private String StockName;
    private double price;
    private String symbol;

    public Stock(String StockName, double price, String symbol){
        this.StockName = StockName;
        this.price = price;
        this.symbol = symbol;
    }

    public String getStockName() { return StockName;}
    public double getPrice() { return price;}
    public String getSymbol() { return symbol;}

    public void refreshPrice(StockService service) {
        this.price = service.updatePrice(this.symbol);
    }
}
