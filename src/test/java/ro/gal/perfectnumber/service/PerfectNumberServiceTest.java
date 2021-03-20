package ro.gal.perfectnumber.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PerfectNumberServiceTest {

    private final PerfectNumberService service = new PerfectNumberService();

    @Test
    void detectsNumberIsPerfect() {
        assertTrue(service.isPerfectNumber(6), "6 is a valid perfect number");
        assertTrue(service.isPerfectNumber(28), "28 is a valid perfect number");
    }

    @Test
    void detectsNumberIsNotPerfect() {
        assertFalse(service.isPerfectNumber(7), "7 is not perfect number");
        assertFalse(service.isPerfectNumber(10), "10 is not perfect number");
    }
}
