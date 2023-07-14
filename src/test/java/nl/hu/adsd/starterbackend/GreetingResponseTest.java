package nl.hu.adsd.starterbackend;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;

class GreetingResponseTest {

    @Test
    public void templateNoPlaceholders() {
        // Arrange
        Greeting greeting = new Greeting(1L, "No placeholder");

        // Act
        GreetingResponse greetingResponse = new GreetingResponse(greeting, "henk");

        // Assert
        assertEquals("No placeholder", greetingResponse.getText());
    }

    @Test
    public void templateTooManyPlaceholders() {
        // Arrange
        Greeting greeting = new Greeting(1L, "Too many placeholders %s %s");

        // Act, Assert
        assertThrows(IllegalFormatException.class, () -> new GreetingResponse(greeting, "henk"));
    }

    @Test
    public void templateCorrectTemplate() {
        // Arrange
        Greeting greeting = new Greeting(1L, "Just one placeholder %s");

        // Act
        GreetingResponse greetingResponse = new GreetingResponse(greeting, "henk");

        // Assert
        assertEquals("Just one placeholder henk", greetingResponse.getText());
    }

}