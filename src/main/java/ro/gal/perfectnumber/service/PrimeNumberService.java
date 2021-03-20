package ro.gal.perfectnumber.service;

import java.util.Arrays;
import java.util.List;

public class PrimeNumberService {


    public boolean isPrimeNumber(long num) {
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
