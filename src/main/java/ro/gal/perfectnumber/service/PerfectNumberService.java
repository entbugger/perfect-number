package ro.gal.perfectnumber.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfectNumberService {

    private final PrimeNumberService primeNumberService;

    public PerfectNumberService() {
        this.primeNumberService = new PrimeNumberService();
    }

    /**
     * Checks whether a number is perfect.
     *
     * Implementation: iterate only to sqrt(number) and add all divisors
     */
    public boolean isPerfectNumber(long number) {
        if (number<0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        if (number % 2 != 0) {//odd numbers are never perfect
            return false;
        }
        int sumOfDividers = 1;
        for (long i=2; i*i<=number; i++) {
            if (number%i == 0) {
                sumOfDividers += i;//add divisor
                sumOfDividers += number / i;//add the other divisor
            }
        }
        return sumOfDividers == number;
    }

    /**
     * Generates perfect numbers between start and end (bigger or equal than start and strictly smaller than end).
     * Uses Euclid–Euler theorem.
     */
    public List<Long> generatePerfectNumbers(long start, long end) {
        List<Long> result = new ArrayList<>();
        for (long p : primeNumberService.generatePrimeNumbers()) {
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

}
