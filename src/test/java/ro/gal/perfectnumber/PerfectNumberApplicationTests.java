package ro.gal.perfectnumber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PerfectNumberApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void checksPerfectNumber() {
        Boolean result = restTemplate.getForObject("http://localhost:" + port + "/perfect-number/check?number=2", Boolean.class);
        assertFalse(result);
        result = restTemplate.getForObject("http://localhost:" + port + "/perfect-number/check?number=28", Boolean.class);
        assertTrue(result);
    }

    @Test
    void generatePerfectNumbers() {
        ResponseEntity<Long[]> response =
            restTemplate.getForEntity("http://localhost:" + port + "/perfect-number/generate?start=2&end=30",
                Long[].class);
        Long[] generatedNumbers = response.getBody();
        assertThat(generatedNumbers).containsExactly(6L, 28L);
    }

}
