package converter.model;

import java.util.ArrayList;

public class CurrencyList {
    private ArrayList<Currency> currencies = new ArrayList<>();

    public void addCurrency(Currency currency) {
        currencies.add(currency);
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }
}