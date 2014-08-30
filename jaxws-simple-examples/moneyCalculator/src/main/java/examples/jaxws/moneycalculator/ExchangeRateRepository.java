package examples.jaxws.moneycalculator;

import examples.jaxws.moneycalculator.api.Currency;
import examples.jaxws.moneycalculator.api.ExchangeRate;
import org.joda.time.LocalDate;

public interface ExchangeRateRepository {

    public ExchangeRate findExchangeRate(Currency currency1, Currency currency2, LocalDate date);
    
}
