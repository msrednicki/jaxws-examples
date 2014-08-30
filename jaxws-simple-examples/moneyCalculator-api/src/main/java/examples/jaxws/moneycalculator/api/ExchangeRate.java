package examples.jaxws.moneycalculator.api;

import static com.google.common.base.Preconditions.*;
import java.math.BigDecimal;

public class ExchangeRate {

    public static final int RATE_SCALE = 6;
    private static final int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
    
    private final Currency currency1;
    private final Currency currency2;
    private final BigDecimal rate;

    public ExchangeRate(Currency currency1, Currency currency2, BigDecimal rate) {
        checkArgument(currency1 != currency2, "Input and output currency should be different");
        checkArgument(BigDecimal.ZERO.compareTo(rate) >= 0, "Rate should be greather than 0");
        
        this.currency1 = currency1;
        this.currency2 = currency2;
        this.rate = rate.setScale(RATE_SCALE, ROUNDING_MODE);
    }

    public Currency getCurrency1() {
        return currency1;
    }

    public Currency getCurrency2() {
        return currency2;
    }

    public BigDecimal getRate() {
        return rate;
    }
    
}
