package examples.jaxws.moneycalculator;

import static com.google.common.base.Preconditions.*;
import examples.jaxws.moneycalculator.api.Currency;
import examples.jaxws.moneycalculator.api.ExchangeRate;
import examples.jaxws.moneycalculator.api.MoneyAmount;
import examples.jaxws.moneycalculator.api.MoneyCalculator;
import org.joda.time.LocalDate;


public class SimpleMoneyCalculator implements MoneyCalculator {

    private final ExchangeRateRepository exchangeRateRepository;

    public SimpleMoneyCalculator(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }
    
    @Override
    public MoneyAmount convertMoney(MoneyAmount moneyAmount, 
                                    Currency outputCurrency, 
                                    LocalDate exchangeRateDate) {
        
        checkArgument(moneyAmount.getCurrency() != outputCurrency, "Output currency shoud be different than money amount currency");
        
        ExchangeRate exchangeRate = 
                exchangeRateRepository.findExchangeRate(moneyAmount.getCurrency(), 
                        outputCurrency, exchangeRateDate);
        
        if (moneyAmount.getCurrency() == exchangeRate.getCurrency1())
            return new MoneyAmount(moneyAmount.getAmount().multiply(exchangeRate.getRate()), 
                    exchangeRate.getCurrency2());
        else
            return new MoneyAmount(moneyAmount.getAmount().divide(exchangeRate.getRate()),
                    exchangeRate.getCurrency1());
    }

}
