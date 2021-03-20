package ro.gal.perfectnumber.service;

import org.springframework.stereotype.Service;

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
        int sumOfDividers = 1;
        for (int i=2; i*i<=number; i++) {
            if (number%i == 0) {
                sumOfDividers += i;//add divisor
                sumOfDividers += number / i;//add the other divisor
            }
        }
        return sumOfDividers == number;
    }
}
