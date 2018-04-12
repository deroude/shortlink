package ro.deroude.shortlink.rest;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.deroude.shortlink.api.InvalidURLException;
import ro.deroude.shortlink.api.ShortLinkGenerator;
import ro.deroude.shortlink.api.URLProcessor;
import ro.deroude.shortlink.domain.Link;
import ro.deroude.shortlink.repository.LinkRepository;

/**
 *
 * @author valentin.raduti
 */
@RestController
@RequestMapping("/link")
public class LinkController {

    private final LinkRepository linkRepository;
    private final ShortLinkGenerator linkGenerator;
    private final URLProcessor urlProcessor;

    @Autowired
    public LinkController(LinkRepository linkRepository, ShortLinkGenerator linkGenerator, URLProcessor urlProcessor) {
	this.linkRepository = linkRepository;
	this.linkGenerator = linkGenerator;
	this.urlProcessor = urlProcessor;
    }

    @PostMapping
    public String getShortLinkForUrl(@RequestBody String url) throws InvalidURLException {
	final String normalizedUrl = urlProcessor.processURL(url);
	Optional<Link> re = this.linkRepository.findByUrl(normalizedUrl);
	if (!re.isPresent()) {
	    Link link = new Link();
	    link.setUrl(normalizedUrl);
	    link.setHash(linkGenerator.generate(linkRepository.count())); //TODO come up with a better way to get a sequence on Elastic
	    this.linkRepository.save(link);
	    return link.getHash();
	}
	return re.get().getHash();
    }    
}
