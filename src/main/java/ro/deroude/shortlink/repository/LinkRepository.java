package ro.deroude.shortlink.repository;

import java.util.Optional;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ro.deroude.shortlink.domain.Link;

/**
 *
 * @author valentin.raduti
 */
public interface LinkRepository extends ElasticsearchRepository<Link, String>{
    
    //TODO keep an eye on Spring Data: when it becomes compatible with Elastic 6.x, remove the @Query
    @Query("{\"term\" : {\"url\" : \"?0\"}}")
    Optional<Link> findByUrl(String url);
    
}
