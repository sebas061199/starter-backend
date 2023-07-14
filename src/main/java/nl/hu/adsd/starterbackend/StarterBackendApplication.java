package nl.hu.adsd.starterbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StarterBackendApplication {

    /**
     * This is what starts-up the sprint boot application.
     * With a default configuration it will scan the classpath in this package and
     * subpackages for annotations (e.g. components, services, entities, repositories etc.)
     *
     * @param args these are passed on to the spring application runner
     */
    public static void main(String[] args) {
        SpringApplication.run(StarterBackendApplication.class, args);
    }

}
