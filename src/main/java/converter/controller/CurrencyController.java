package converter.controller;

import converter.model.Currency;
import converter.model.CurrencyList;

import java.util.ArrayList;

public class CurrencyController {
    private CurrencyList currencyList = new CurrencyList();

    public CurrencyController() {
        currencyList.addCurrency(new Currency("EUR", "Euro", 1.0));
        currencyList.addCurrency(new Currency("USD", "US Dollar", 1.10));
        currencyList.addCurrency(new Currency("GBP", "British Pound", 0.84));
        currencyList.addCurrency(new Currency("JPY", "Japanese Yen", 174.0));
        currencyList.addCurrency(new Currency("SEK", "Swedish Krona", 11.21));
        currencyList.addCurrency(new Currency("VND", "Vietnamese Dong", 28279.0));
    }

    public ArrayList<Currency> getCurrencies() {
        return currencyList.getCurrencies();
    }

    public String convert(String amountText, Currency from, Currency to) {
        if (from == null || to == null) {
            return "Please choose both currencies.";
        }

        if (amountText == null ) {
            return "Please enter an amount.";
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return "The amount must be a number.";
        }

        if (amount < 0) {
            return "The amount can't be negative.";
        }

        double result = amount / from.getRate() * to.getRate();
        double rounded = Math.round(result * 100) / 100.0;

        return "" + rounded;
    }
}