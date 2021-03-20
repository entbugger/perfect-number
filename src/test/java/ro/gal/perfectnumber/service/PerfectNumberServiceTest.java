package ro.gal.perfectnumber.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfectNumberServiceTest {

    private PerfectNumberService service = new PerfectNumberService();

    @Test
    public void detectsNumberIsPerfect() {
        assertTrue(service.isPerfectNumber(6), "6 is a valid perfect number");
        assertTrue(service.isPerfectNumber(28), "28 is a valid perfect number");
    }

    @Test
    public void detectsNumberIsNotPerfect() {
        assertFalse(service.isPerfectNumber(7), "7 is not perfect number");
        assertFalse(service.isPerfectNumber(10), "10 is not perfect number");
    }
}
