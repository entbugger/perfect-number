package ro.gal.perfectnumber.service;

import java.util.List;

public interface PerfectNumberService {
    boolean isPerfectNumber(long number);
    List<Long> generatePerfectNumbers(long start, long end);
}
