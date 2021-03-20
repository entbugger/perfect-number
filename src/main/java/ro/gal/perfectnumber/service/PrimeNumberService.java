package ro.gal.perfectnumber.service;

import java.util.Arrays;
import java.util.List;

public interface PrimeNumberService {

    boolean isPrimeNumber(long num);

    List<Long> generatePrimeNumbers();
}
