package ro.gal.perfectnumber.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class NaivePrimeNumberService implements PrimeNumberService {


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

    public List<Long> generatePrimeNumbers(long max) {
        List<Long> results = new ArrayList<>();
        for (long i=2; i<max; i++) {
            if (isPrimeNumber(i)) {
                results.add(i);
            }
        }

        return results;
    }
}
