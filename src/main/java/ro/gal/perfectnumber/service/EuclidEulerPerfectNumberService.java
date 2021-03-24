package ro.gal.perfectnumber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Uses the Euclid-Euler theorem to check if a number is perfect and for generation of perfect numbers.
 */
@Service
public class EuclidEulerPerfectNumberService implements PerfectNumberService {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private final PrimeNumberService primeNumberService;

    @Autowired
    public EuclidEulerPerfectNumberService(PrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
    }

    /**
     * Checks whether a number is perfect.
     *
     */
    @Override
    public boolean isPerfectNumber(BigInteger number) {
        if (number.signum()<0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        if (!isEven(number)) {//there are no known perfect numbers that are odd
            return false;
        }
        //an even number is perfect iff it is of form (2^p-1)*2^(p-1) where (2^p-1) is prime
        int p = 0;//find out p-1
        BigInteger tmp = number;
        while (isEven(tmp)) {
            tmp = tmp.divide(TWO);
            p++;
        }
        p++;//we need p, not p-1
        return number.equals(TWO.pow(p - 1).multiply(TWO.pow(p).subtract(ONE)))
            && primeNumberService.isPrimeNumber(pow(2, p)-1);
    }

    /**
     * Generates perfect numbers between start and end (bigger or equal than 'start' and strictly smaller than 'end').
     * Uses Euclid–Euler theorem: an even perfect number is of form (2^p-1)*2^(p-1) where (2^p-1) is prime.
     */
    @Override
    public List<Long> generatePerfectNumbers(long start, long end) {
        List<Long> result = new ArrayList<>();
        long maxPrimeNumberToCheck = (long) Math.ceil((log(2, end) + 1) / 2)+1;
        for (long p : primeNumberService.generatePrimeNumbers(maxPrimeNumberToCheck)) {
            if (primeNumberService.isPrimeNumber(pow(2, p) - 1)) {
                long perfectNumber = pow(2, p - 1) * (pow(2, p) - 1);
                if (perfectNumber >= start && perfectNumber < end) {
                    result.add(perfectNumber);
                }
            }
        }

        return result;
    }

    private long pow(long base, long exponent) {
        return (long)Math.pow(base, exponent);
    }

    private double log(long base, long num) {
        return Math.log(num) / Math.log(base);
    }

    private boolean isEven(BigInteger n) {
        return ZERO.equals(n.remainder(TWO));
    }
}
