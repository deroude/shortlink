package ro.deroude.shortlink.api;

/**
 *
 * @author valentin.raduti
 */
public interface URLProcessor {

    /**
     * Normalize a URL to a standard representation
     * @param url -- an argument given for normalization
     * @return a standard representation
     * @throws IllegalArgumentException if the argument is not a properly formed URL
     */
    public String processURL(String url) throws InvalidURLException;
}
