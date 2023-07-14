package nl.hu.adsd.starterbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "http://localhost:[*]")
@RestController
@RequestMapping(path="/greeting")
public class GreetingController {
    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    private final GreetingHelper greetingHelper;

    GreetingController(GreetingHelper greetingHelper) {
        this.greetingHelper = greetingHelper;
    }

    /**
     * Select a random greeting template from the database and respond with the provided name filled in.
     *
     * @param name provided name to be filled into the {@link GreetingResponse(Greeting, String)}
     *
     * @return a GreetingResponse (will be serialized to JSON)
     */
    @GetMapping("/random")
    public GreetingResponse getRandomGreeting(@RequestParam String name) {
        logger.info("Got request for random greeting with name '" + name + "'");
        Greeting randomGreeting = greetingHelper.selectRandomGreeting();
        logger.info("Random greeting selected " + randomGreeting);
        return new GreetingResponse(randomGreeting, name);
    }
}
