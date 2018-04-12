package ro.deroude.shortlink.rest;

import ro.deroude.shortlink.api.ResourceNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.deroude.shortlink.api.StatisticsExtractor;
import ro.deroude.shortlink.domain.Access;
import ro.deroude.shortlink.domain.Link;
import ro.deroude.shortlink.repository.AccessRepository;
import ro.deroude.shortlink.repository.LinkRepository;

/**
 *
 * @author valentin.raduti
 */
@RestController
@RequestMapping("/to")
public class RedirectController {

    private final LinkRepository linkRepository;
    private final AccessRepository accessRepository;
    private final StatisticsExtractor<Access> accessStatisticsExtractor;
    private final ExecutorService statsPool = new ThreadPoolExecutor(2, Math.max(2, Runtime.getRuntime().availableProcessors() / 2), 100l,
	    TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5000), new ThreadPoolExecutor.DiscardOldestPolicy());

    @Autowired

    public RedirectController(LinkRepository linkRepository, AccessRepository accessRepository, StatisticsExtractor<Access> accessStatisticsExtractor) {
	this.linkRepository = linkRepository;
	this.accessRepository = accessRepository;
	this.accessStatisticsExtractor = accessStatisticsExtractor;
    }

    @GetMapping("/{hash}")
    public void redirect(@PathVariable("hash") String hash, HttpServletRequest request, HttpServletResponse response) throws ResourceNotFoundException, IOException {
	Optional<Link> re = this.linkRepository.findById(hash);
	if (!re.isPresent()) {
	    throw new ResourceNotFoundException("Hash " + hash + " not found");
	}
	response.sendRedirect(re.get().getUrl());
	statsPool.submit(() -> {
	    this.accessRepository.save(accessStatisticsExtractor.extract(request, hash));
	});
    }
}
