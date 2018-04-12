package ro.deroude.shortlink.api.impl;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import ro.deroude.shortlink.api.InvalidURLException;
import ro.deroude.shortlink.api.URLProcessor;

/**
 *
 * @author valentin.raduti
 */
@Component
public class DefaultURLProcessor implements URLProcessor {

    private final Pattern urlPattern = Pattern.compile("^(https?|ftp|file):\\/\\/[-a-zA-Z0-9+&@#\\/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#\\/%=~_|]");

    @Override
    public String processURL(String url) throws InvalidURLException {
	if (url != null && urlPattern.matcher(url).matches()) {
	    return url;
	}
	throw new InvalidURLException("Url [" + url + "] is not valid");
    }

}
