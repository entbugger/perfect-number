package ro.gal.perfectnumber.service;

import java.math.BigInteger;
import java.util.List;

public interface PerfectNumberService {
    boolean isPerfectNumber(BigInteger number);
    List<BigInteger> generatePerfectNumbers(BigInteger start, BigInteger end);
}
