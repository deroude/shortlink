package ro.deroude.shortlink.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *
 * @author valentin.raduti
 */
@Document(indexName = "link", type = "link", shards = 1, replicas = 0, refreshInterval = "-1")
public class Link {

    @Id
    private String hash;

    @Field(type = FieldType.keyword,index = true)
    private String url;

    public Link() {
    }

    public Link(String url) {
	this.url = url;
    }

    public String getHash() {
	return hash;
    }

    public void setHash(String hash) {
	this.hash = hash;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

}
