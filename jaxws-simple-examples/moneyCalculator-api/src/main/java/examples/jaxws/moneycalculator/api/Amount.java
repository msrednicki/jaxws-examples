package examples.jaxws.moneycalculator.api;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Amount implements Comparable<Amount>{

    public static final Amount ZERO = new Amount(BigDecimal.ZERO);
    
    private static final int SCALE = 2;
    private static final int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
    
    private final BigDecimal value;
    
    public Amount(String value) {
        this(new BigDecimal(value));
    }
    
    public Amount(BigDecimal value) {
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }
    
    public BigDecimal bigDecimalValue() {
        return value;
    }

    public Amount add(Amount augend) {
        return new Amount(this.value.add(augend.value));
    }
    
    public Amount subtract(Amount subtrahend) {
        return new Amount(this.value.subtract(subtrahend.value));
    }
    
    public Amount multiply(BigDecimal multiplicand) {
        return new Amount(this.value.multiply(multiplicand));
    }
    
    public BigDecimal divide(Amount divisor, int scale, RoundingMode roundingMode) {
        return this.value.divide(divisor.value, scale, roundingMode);
    }
    
    public Amount divide(BigDecimal divisor) {
        return new Amount(this.value.divide(divisor, SCALE, ROUNDING_MODE));
    }
    
    public boolean isGreaterThan(Amount other) {
        return this.compareTo(other) > 0;
    }
    
    public boolean isLowerThan(Amount other) {
        return this.compareTo(other) < 0;
    }
    
    public static Amount max(Amount amount1, Amount amount2) {
        if (amount1.isGreaterThan(amount2))
            return amount1;
        else 
            return amount2;
    }

    public static Amount min(Amount amount1, Amount amount2) {
        if (amount1.isLowerThan(amount2))
            return amount1;
        else 
            return amount2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Amount other = (Amount) obj;
        return this.value == other.value || (this.value != null && this.value.equals(other.value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toPlainString();
    }

    public int compareTo(Amount o) {
        return this.value.compareTo(o.value);
    }

}
