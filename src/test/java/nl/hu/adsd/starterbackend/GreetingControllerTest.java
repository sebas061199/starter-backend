package nl.hu.adsd.starterbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void getRandomGreeting() {
        String url = "http://localhost:" + port + "/greeting/random?name=henk";
        GreetingResponse greetingResponse = restTemplate.getForEntity(url, GreetingResponse.class).getBody();

        assertNotNull(greetingResponse);
        String text = greetingResponse.getText();

        assertTrue(text.contains("henk"));
    }
}