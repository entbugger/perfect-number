package ro.gal.perfectnumber.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeNumberServiceTest {

    private final PrimeNumberService service = new NaivePrimeNumberService();

    @Test
    void generatesPrimeNumbers() {
        List<Long> primeNumbers = service.generatePrimeNumbers(14L);
        assertThat(primeNumbers).containsExactly(2L, 3L, 5L, 7L, 11L, 13L);
    }
}
