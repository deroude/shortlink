package ro.deroude.shortlink.api.impl;

import org.springframework.stereotype.Component;
import ro.deroude.shortlink.api.ShortLinkGenerator;

/**
 *
 * @author valentin.raduti
 */
@Component
public class DefaultShortLinkGenerator implements ShortLinkGenerator {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    public String generate(long sequenceNumber) {
	StringBuilder sb = new StringBuilder("ly");
	while (sequenceNumber > 0) {
	    sb.append(ALPHABET.charAt((int) (sequenceNumber % ALPHABET.length())));
	    sequenceNumber /= ALPHABET.length();
	}
	return sb.reverse().toString();
    }

}
