package ro.gal.perfectnumber.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeNumberServiceTest {

    private final PrimeNumberService service = new NaivePrimeNumberService();

    @Test
    void generatesPrimeNumbers() {
        List<Long> primeNumbers = service.generatePrimeNumbers(1L, 14L);
        assertThat(primeNumbers).containsExactly(2L, 3L, 5L, 7L, 11L, 13L);
    }
}
