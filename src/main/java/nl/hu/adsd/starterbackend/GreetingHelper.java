package nl.hu.adsd.starterbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class GreetingHelper {
    private static final Logger logger = LoggerFactory.getLogger(GreetingHelper.class);

    private final GreetingRepository greetingRepository;

    public GreetingHelper(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    /**
     * @return A random {@link Greeting} from the database
     */
    public Greeting selectRandomGreeting() {
        Iterable<Greeting> greetings = greetingRepository.findAll();
        List<Greeting> greetingList = new ArrayList<>();
        greetings.forEach(greetingList::add);
        logger.info("Got all greetings from database, size is " + greetingList.size());
        if (greetingList.isEmpty()) {
            String message = "No greetings found in database, please add at least one.";
            logger.error(message);
            throw new NoSuchElementException(message);
        }
        int randomIndex = (new Random()).nextInt(greetingList.size());
        logger.info("Random index for greeting " + randomIndex);
        return greetingList.get(randomIndex);
    }
}
