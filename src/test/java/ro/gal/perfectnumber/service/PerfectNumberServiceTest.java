package ro.gal.perfectnumber.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PerfectNumberServiceTest {

    private final PerfectNumberService service = new PerfectNumberService();

    @Test
    void detectsNumberIsPerfect() {
        List<Long> firstPerfectNumbers = Arrays.asList(6L, 28L, 496L, 8128L, 33550336L/*, 8589869056L,
            137438691328L, 2305843008139952128L*/);
        for (Long i : firstPerfectNumbers) {
            assertTrue(service.isPerfectNumber(i), i + "is a valid perfect number");
        }
    }

    @Test
    void detectsNumberIsNotPerfect() {
        assertFalse(service.isPerfectNumber(7), "7 is not perfect number");
        assertFalse(service.isPerfectNumber(10), "10 is not perfect number");
    }

    @Test
    void generatesPerfectNumbers() {
        List<Long> perfectNumbers = service.generatePerfectNumbers(2, 8129);
        assertThat(perfectNumbers).containsExactly(6L, 28L, 496L, 8128L);
    }
}
