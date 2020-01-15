package moneycalculator.controller;

/**
 *
 * @author Néstor
 */

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency currency);
}