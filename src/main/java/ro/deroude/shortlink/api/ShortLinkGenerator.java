package ro.deroude.shortlink.api;

/**
 *
 * @author valentin.raduti
 */
public interface ShortLinkGenerator {
    /**
     * Generates a representation of a number as a string, unique for the context of the application.
     * @param sequenceNumber a numeric identifier
     * @return a unique representation of the sequenceNumber as a string
     */
    public String generate(long sequenceNumber);
}
