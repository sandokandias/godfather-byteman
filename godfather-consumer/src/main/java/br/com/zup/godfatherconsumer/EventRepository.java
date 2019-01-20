package br.com.zup.godfatherconsumer;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventRepository {

    public static final String COLLECTION_NAME = "json_events";

    private final MongoTemplate mongoTemplate;

    public EventRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(String event) {
        mongoTemplate.save(event, COLLECTION_NAME);
    }
}
