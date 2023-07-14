package nl.hu.adsd.starterbackend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * JPA Entity for representing a greeting record from the database.
 * A greeting has an id and a 'template'. The template is a String where '%s' can be replaced with a provided name
 * using the {@link java.lang.String#formatted(java.lang.Object...)}
 *
 * See also: <a href="https://www.baeldung.com/jpa-entities">JPA Entities (Baeldung)</a>
 */
@Entity
public class Greeting {

    @Id
    @GeneratedValue
    private Long id;

    private String template;

    public Greeting() {
        // default constructor for JPA
    }

    Greeting(Long id, String template) {
        // constructor for tests
        this.id = id;
        this.template = template;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", template='" + template + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return Objects.equals(id, greeting.id) && Objects.equals(template, greeting.template);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, template);
    }
}
