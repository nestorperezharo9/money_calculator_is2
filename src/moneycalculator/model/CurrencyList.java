package moneycalculator.model;

/**
 *
 * @author Néstor
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class CurrencyList {
    private final List<Currency> currencies = new ArrayList<>();

    public CurrencyList() {
        add(new Currency("GBP", "Libra", "£"));
        add(new Currency("PLN", "Zloty polaco", "zł"));
        add(new Currency("USD", "Dolar", "$"));
        add(new Currency("KRW", "Won surcoreano", "₩"));
    }

    private void add(Currency currency) {
        currencies.add(currency);
    }


    public List<Currency> getList() {
        return currencies;
    }
}