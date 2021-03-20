package ro.gal.perfectnumber.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfectNumberServiceTest {

    private PerfectNumberService service = new PerfectNumberService();

    @Test
    public void checksNumberIsPerfect() {
        assertTrue(service.isPerfectNumber(6), "6 is a valid perfect number");
    }
}
