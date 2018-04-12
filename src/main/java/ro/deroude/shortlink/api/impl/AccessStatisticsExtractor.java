package ro.deroude.shortlink.api.impl;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import ro.deroude.shortlink.api.StatisticsExtractor;
import ro.deroude.shortlink.domain.Access;

/**
 *
 * @author valentin.raduti
 */
@Component
public class AccessStatisticsExtractor implements StatisticsExtractor<Access> {

    @Override
    public Access extract(HttpServletRequest request, Object... args) {
	String ipAddress = request.getHeader("X-FORWARDED-FOR");
	if (ipAddress == null) {
	    ipAddress = request.getRemoteAddr();
	}
	return new Access((String) args[0], new Date(), ipAddress);
    }

}
