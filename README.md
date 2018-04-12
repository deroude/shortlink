# Shortlink app

## Requirement

### Description

Most of us are familiar with seeing URLs like bit.ly or t.co on our Twitter or Facebook feeds. 
These are examples of shortened URLs, which are a short alias or pointer to a longer page link. 
For example, I can send you the shortened URL http://bit.ly/SaaYw5 that will forward you to a very long Google URL with search results on how to iron a shirt.

### Mandatory Requirements

Design and implement an API for short URL creation
Implement forwarding of short URLs to the original ones
There should be some form of persistent storage
The application should be distributed as one or more Docker images

### Additional Requirements

Design and implement an API for gathering different statistics

### Assessment

Treat this as a real project. It should be readable, maintainable, and extensible where appropriate.

The implementation should preferably be in Java, however any language can be used.

If you will transfer it to another team - it should be clear how to work with it and what is going on.

You should send us a link to a Git repository that we will be able to clone.

## Implementation

### Technology stack

- Spring Boot 2 (to keep the project within 2 hours)
- Elastic Stack 6 (best match for statistics gathering, mining and visualizing)

### Usage

``` 
git clone https://github.com/deroude/shortlink.git deroude-shortlink
cd deroude-shortlink
mvn clean install
docker-compose up --build
```

The following methods are available:

`POST http://localhost:8080/link BODY http://your.address.com/with/a/long/path` will yeld a hash.

`GET http://localhost:8080/to/hash` will redirect to the original URL.

The latter method will also add information to Elastic about the redirect (hash, origin & timestamp).

To access Kibana, navigate to http://localhost:5601

### Notes

At this stage, the app provides naive implementations for URL processing and short link generation, as well as for a distributed numeric sequence mechanism.

To run the application outside Docker:

- change `application.yml` to point to `localhost` instead of `elasticsearch`
- run the Elastic stack using `docker-compose -f docker-compose_elk.yml up`, then run the application from the IDE or shell.
