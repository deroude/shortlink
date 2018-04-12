package ro.deroude.shortlink.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *
 * @author valentin.raduti
 */
@Document(indexName = "access", type = "access", shards = 1, replicas = 0, refreshInterval = "-1")
public class Access {

    @Id
    private String id;

    @Field(type = FieldType.text, index = true)
    private String hash;

    @Field(type = FieldType.Date, index = true)
    private Date timestamp;

    @Field(type = FieldType.text, index = false)
    private String source;

    public Access() {
    }

    public Access(String hash, Date timestamp, String source) {
	this.hash = hash;
	this.timestamp = timestamp;
	this.source = source;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getHash() {
	return hash;
    }

    public void setHash(String hash) {
	this.hash = hash;
    }

    public Date getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
    }

    public String getSource() {
	return source;
    }

    public void setSource(String source) {
	this.source = source;
    }

}
