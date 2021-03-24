package ro.gal.perfectnumber.service;

import java.math.BigInteger;
import java.util.List;

public interface PerfectNumberService {
    boolean isPerfectNumber(BigInteger number);
    List<Long> generatePerfectNumbers(long start, long end);
}
