package ro.gal.perfectnumber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EuclidEulerPerfectNumberService implements PerfectNumberService {

    private final PrimeNumberService primeNumberService;

    @Autowired
    public EuclidEulerPerfectNumberService(PrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
    }

    /**
     * Checks whether a number is perfect.
     *
     * Implementation: iterate only to sqrt(number) and add all divisors
     */
    @Override
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

}
