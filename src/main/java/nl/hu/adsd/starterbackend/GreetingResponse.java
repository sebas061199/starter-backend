package nl.hu.adsd.starterbackend;


/**
 * This class will represent the (base) response to a greeting request. It may be serialized to json format
 */
public class GreetingResponse {
    private String text;

    public GreetingResponse() {
        // for jackson (json) deserialization
    }

    public GreetingResponse(Greeting greeting, String name) {
        this.text = greeting.getTemplate().formatted(name);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
