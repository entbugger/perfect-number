package ro.gal.perfectnumber.service;

import java.util.List;

public interface PrimeNumberService {

    boolean isPrimeNumber(long num);

    List<Long> generatePrimeNumbers(long max);
}
