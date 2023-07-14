package nl.hu.adsd.starterbackend;

import org.springframework.data.repository.CrudRepository;


/**
 * A default CrudRepository for creating, retrieving, updating and deleting
 * Greeting records from the database.
 * See also:
 * <a href="https://docs.spring.io/spring-data/data-commons/docs/3.1.x/reference/html/#repositories">
 *     Working with Spring Data Repositories</a>
 */
public interface GreetingRepository extends CrudRepository<Greeting, Long> {

}
