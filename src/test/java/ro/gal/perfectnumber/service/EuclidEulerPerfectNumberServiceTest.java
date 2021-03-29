package ro.gal.perfectnumber.service;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static java.math.BigInteger.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EuclidEulerPerfectNumberServiceTest {

    private final EuclidEulerPerfectNumberService service = new EuclidEulerPerfectNumberService(new NaivePrimeNumberService());

    @Test
    void detectsNumberIsPerfect() {
        List<Long> firstPerfectNumbers = Arrays.asList(6L, 28L, 496L, 8128L, 33550336L, 8589869056L,
            137438691328L, 2305843008139952128L);
        for (Long i : firstPerfectNumbers) {
            assertTrue(service.isPerfectNumber(valueOf(i)), i + "is a valid perfect number");
        }
    }

    @Test
    void detectsNumberIsNotPerfect() {
        assertFalse(service.isPerfectNumber(valueOf(7)), "7 is not perfect number");
        assertFalse(service.isPerfectNumber(valueOf(10)), "10 is not perfect number");
    }

    @Test
    void generatesPerfectNumbers() {
        List<BigInteger> perfectNumbers = service.generatePerfectNumbers(valueOf(2), valueOf(8129));
        assertThat(perfectNumbers).containsExactly(valueOf(6L), valueOf(28L), valueOf(496L), valueOf(8128L));
    }
}
