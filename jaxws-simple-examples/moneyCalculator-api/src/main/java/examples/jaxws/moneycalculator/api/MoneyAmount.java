package examples.jaxws.moneycalculator.api;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static com.google.common.base.Preconditions.*;

public class MoneyAmount {
    
    private final static String ILLEGAL_MONEYAMOUNT_CURRENCY = 
            "Argument's currency should equal this currency";
    
    private final Amount amount;
    private final Currency currency;
    
    public MoneyAmount(Amount amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
        
    public MoneyAmount add(MoneyAmount augend) {
        checkArgument(this.currency == augend.currency, ILLEGAL_MONEYAMOUNT_CURRENCY);
        return new MoneyAmount(this.amount.add(augend.amount), this.currency);
    }
    
    public MoneyAmount subtract(MoneyAmount subtrahend) {
        checkArgument(this.currency == subtrahend.currency, ILLEGAL_MONEYAMOUNT_CURRENCY);
        return new MoneyAmount(this.amount.subtract(subtrahend.amount), this.currency);
    }
    
    public MoneyAmount multiply(BigDecimal multiplicand) {
        return new MoneyAmount(this.amount.multiply(multiplicand), this.currency);
    }
    
    public BigDecimal divide(MoneyAmount divisor, int scale, RoundingMode roundingMode) {
        checkArgument(this.currency == divisor.currency, ILLEGAL_MONEYAMOUNT_CURRENCY);
        return this.amount.divide(divisor.amount, scale, roundingMode);
    }
    
    public MoneyAmount divide(BigDecimal divisor) {
        return new MoneyAmount(this.amount.divide(divisor), this.currency);
    }
    
    
    public Amount getAmount() {
        return this.amount;
    }
    
    public Currency getCurrency() {
        return this.currency;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MoneyAmount other = (MoneyAmount) obj;
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (this.currency != other.currency) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.amount.toString() + " " + this.currency;
    }
}
