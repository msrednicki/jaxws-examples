package examples.jaxws.moneycalculator.api;

import org.joda.time.LocalDate;

public interface MoneyCalculator {

    MoneyAmount convertMoney(MoneyAmount moneyAmount, Currency outputCurrency, LocalDate exchangeRateDate);
    
}
