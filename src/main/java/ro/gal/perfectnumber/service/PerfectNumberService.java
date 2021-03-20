package ro.gal.perfectnumber.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PerfectNumberService {

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
        for (long p : generatePrimeNumbers()) {
            if (isPrime(pow(2, p) - 1)) {
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

    private boolean isPrime(long num) {
        if(num <= 1) {
            return false;
        }
        if(num <= 3) {
            return true;
        }

        if(num%2==0 || num%3==0)  {
            return false;
        }

        for(long i=5; i*i<=num; i=i+6)
            if(num % i == 0 || num%(i+2)==0) {
                return false;
            }

        return true;
    }

    public List<Long> generatePrimeNumbers() {
        return Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L);
    }
}
