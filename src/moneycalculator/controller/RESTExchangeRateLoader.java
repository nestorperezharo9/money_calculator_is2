package moneycalculator.controller;

/**
 *
 * @author Néstor
 */

import com.google.gson.Gson;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.ExchangeRateResponse;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RESTExchangeRateLoader implements ExchangeRateLoader {

    public RESTExchangeRateLoader() {
    }

    @Override
    public ExchangeRate load(Currency currency) {
        try {

            URL url = new URL("https://api.exchangeratesapi.io/latest");
            Scanner api = new Scanner(url.openStream());
            String responseText = api.nextLine();

            Gson gson = new Gson();
            //System.out.println("Response text: " + responseText);
            ExchangeRateResponse response = gson.fromJson(responseText, ExchangeRateResponse.class);
            Currency baseCurrency = null;

            ExchangeRate result = null;

            for (Map.Entry<String, Double> entry : response.getRates().entrySet()) {
                if (currency.getCode().equals(entry.getKey())) {
                    ExchangeRate er = new ExchangeRate(entry.getValue(), response.getDate(), baseCurrency, currency);
                    return er;
                }
            }

            return result;

        }
        catch (Exception e) {
            System.out.println("Exception " + e);
            e.printStackTrace();
        }
        return null;
    }
}