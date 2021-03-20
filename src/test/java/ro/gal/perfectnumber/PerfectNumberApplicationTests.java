package ro.gal.perfectnumber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PerfectNumberApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void checksPerfectNumber() {
        Boolean result = restTemplate.getForObject("http://localhost:" + port + "/perfect-number/check?number=2", Boolean.class);
        assertThat(result).isEqualTo(false);
        result = restTemplate.getForObject("http://localhost:" + port + "/perfect-number/check?number=28", Boolean.class);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void generatePerfectNumbers() {
        List result = restTemplate.getForObject("http://localhost:" + port + "/perfect-number/generate?start=2&end=30", List.class);
        assertThat(result).containsExactly(false);
    }

}
