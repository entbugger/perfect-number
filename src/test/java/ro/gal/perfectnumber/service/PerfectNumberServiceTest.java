package ro.gal.perfectnumber.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PerfectNumberServiceTest {

    private final PerfectNumberService service = new PerfectNumberService();

    @Test
    void detectsNumberIsPerfect() {
        List<Integer> firstPerfectNumbers = Arrays.asList(6, 28, 496, 8128, 33550336);
        for (Integer i : firstPerfectNumbers) {
            assertTrue(service.isPerfectNumber(i), i + "is a valid perfect number");
        }
    }

    @Test
    void detectsNumberIsNotPerfect() {
        assertFalse(service.isPerfectNumber(7), "7 is not perfect number");
        assertFalse(service.isPerfectNumber(10), "10 is not perfect number");
    }
}
