package ro.deroude.shortlink.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ro.deroude.shortlink.domain.Access;

/**
 *
 * @author valentin.raduti
 */
public interface AccessRepository extends ElasticsearchRepository<Access, String>{
    
}
