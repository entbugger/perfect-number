package ro.gal.perfectnumber.service;

import org.springframework.stereotype.Service;

@Service
public class PerfectNumberService {

    /**
     * Naive implementation of checking whether a number is perfect.
     */
    public boolean isPerfectNumber(int number) {
        int sumOfDividers = 0;
        for (int i=1; i<number; i++) {
            if (number%i == 0) {
                sumOfDividers += i;
            }
        }
        return sumOfDividers == number;
    }
}
