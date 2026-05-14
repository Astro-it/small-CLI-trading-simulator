package test;
import com.google.gson.annotations.SerializedName;

public class StockQuote {
    @SerializedName("c")
    private double currentPrice;

    public double getCurrentPrice() { return currentPrice; }
}
