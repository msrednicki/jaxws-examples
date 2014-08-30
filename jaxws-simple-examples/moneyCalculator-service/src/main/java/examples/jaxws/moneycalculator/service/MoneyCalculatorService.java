package examples.jaxws.moneycalculator.service;

import examples.jaxws.moneycalculator.RandomExchangeRateRepository;
import examples.jaxws.moneycalculator.SimpleMoneyCalculator;
import examples.jaxws.moneycalculator.api.Currency;
import examples.jaxws.moneycalculator.api.LocalDateXMLAdapter;
import examples.jaxws.moneycalculator.api.MoneyAmount;
import examples.jaxws.moneycalculator.api.MoneyCalculator;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.LocalDate;

@WebService(serviceName = "MoneyCalculatorService")
public class MoneyCalculatorService implements MoneyCalculator {

    private final MoneyCalculator moneyCalculator;

    public MoneyCalculatorService() {
        this.moneyCalculator = new SimpleMoneyCalculator(new RandomExchangeRateRepository());
    }
    
    @Override
    @WebMethod()
    public MoneyAmount convertMoney(
            @WebParam(name = "moneyAmount")
            MoneyAmount moneyAmount, 
            @WebParam(name = "currency")
            Currency outputCurrency, 
            @WebParam(name = "exchangeRateDate")
            @XmlJavaTypeAdapter(type=LocalDate.class, value=LocalDateXMLAdapter.class)
            LocalDate exchangeRateDate) {
        return moneyCalculator.convertMoney(moneyAmount, outputCurrency, exchangeRateDate);
    }

}
