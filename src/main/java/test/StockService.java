package test;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StockService {
    private final Gson gson = new Gson();
    private final HttpClient client = HttpClient.newHttpClient();
    StockQuote quote;

    public double updatePrice(String symbol) {
        String apiKey = AppConfig.getFinnhubKey();
        String url = "https://finnhub.io/api/v1/quote?symbol=" + symbol + "&token=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            StockQuote quote = gson.fromJson(response.body(), StockQuote.class);

            double CurrentPrice = quote.getCurrentPrice();
            return CurrentPrice;

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}