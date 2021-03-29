package ro.gal.perfectnumber.service;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

@Component
public class NaivePrimeNumberService implements PrimeNumberService {
    private static final BigInteger TWO = valueOf(2);
    private static final BigInteger THREE = valueOf(3);
    private static final BigInteger FIVE = valueOf(5);
    private static final BigInteger SIX = valueOf(6);
    public boolean isPrimeNumber(BigInteger num) {
        if(num.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }
        if(num.compareTo(THREE) <= 0) {
            return true;
        }

        if(isDivisibleBy(num, TWO) || isDivisibleBy(num, THREE))  {
            return false;
        }

        for(BigInteger i=FIVE; i.multiply(i).compareTo(num)<=0; i=i.add(SIX))
            if(isDivisibleBy(num, i) || isDivisibleBy(num, i.add(TWO))) {
                return false;
            }

        return true;
    }

    public List<Long> generatePrimeNumbers(long min, long max) {
        List<Long> results = new ArrayList<>();
        for (long i=min; i<max; i++) {
            if (isPrimeNumber(valueOf(i))) {
                results.add(i);
            }
        }

        return results;
    }

    private boolean isDivisibleBy(BigInteger n, BigInteger by) {
        return ZERO.equals(n.remainder(by));
    }
}
