package ro.gal.perfectnumber.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.math.BigInteger.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeNumberServiceTest {

    private final PrimeNumberService service = new NaivePrimeNumberService();

    @Test
    void generatesPrimeNumbers() {
        List<Long> primeNumbers = service.generatePrimeNumbers(1L, 14L);
        assertThat(primeNumbers).containsExactly(2L, 3L, 5L, 7L, 11L, 13L);
    }

    @Test
    void detectsNumberIsPrime() {
        assertTrue(service.isPrimeNumber(valueOf(6803)));
        assertTrue(service.isPrimeNumber(valueOf(43133)));
        assertTrue(service.isPrimeNumber(valueOf(92489)));
    }

    @Test
    void detectsNumberIsNotPrime() {
        assertFalse(service.isPrimeNumber(valueOf(1231232132)));
        assertFalse(service.isPrimeNumber(valueOf(96417)));
        assertFalse(service.isPrimeNumber(valueOf(92487)));
    }
}
