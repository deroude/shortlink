package ro.deroude.shortlink.api;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author valentin.raduti
 * @param <T> Statistics POJO that holds the result of the extraction
 */
public interface StatisticsExtractor<T> {

    /**
     * Extracts a set of statistic information from a request
     * @param req the web request
     * @return a POJO containing the extracted stats
     */
    public T extract(HttpServletRequest req, Object... args);
}
