package nl.hu.adsd.starterbackend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class GreetingHelperTest {

    @Mock
    private GreetingRepository greetingRepository;

    @Test
    void selectRandomGreetingSingleton() {
        // Arrange
        Greeting greeting1 = new Greeting(1L, "Hi %s");
        doReturn(List.of(greeting1)).when(greetingRepository).findAll();
        GreetingHelper greetingHelper = new GreetingHelper(greetingRepository);

        // Act
        Greeting randomGreeting = greetingHelper.selectRandomGreeting();

        // Assert
        assertEquals(randomGreeting, greeting1);
    }

    @Test
    void selectRandomGreetingsEmpty() {
        // Arrange
        doReturn(List.of()).when(greetingRepository).findAll();
        GreetingHelper greetingHelper = new GreetingHelper(greetingRepository);

        // Act, Assert
        assertThrows(NoSuchElementException.class, greetingHelper::selectRandomGreeting);
    }
}