package examples.jaxws.moneycalculator;

import examples.jaxws.moneycalculator.api.Currency;
import examples.jaxws.moneycalculator.api.ExchangeRate;
import java.math.BigDecimal;
import java.util.Random;
import org.joda.time.LocalDate;

public class RandomExchangeRateRepository implements ExchangeRateRepository {

    @Override
    public ExchangeRate findExchangeRate(Currency currency1, Currency currency2, LocalDate date) {
        Random random = new Random();
        
        return new ExchangeRate(currency1, currency2, new BigDecimal(random.nextDouble() * 10));
    }

}
