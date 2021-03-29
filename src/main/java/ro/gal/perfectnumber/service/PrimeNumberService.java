package ro.gal.perfectnumber.service;

import java.math.BigInteger;
import java.util.List;

public interface PrimeNumberService {

    boolean isPrimeNumber(BigInteger num);

    List<Long> generatePrimeNumbers(long min, long max);
}
