package br.com.zup.godfatherconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventRepository {

    public static final String COLLECTION_NAME = "godfather_events";

    private final MongoTemplate mongoTemplate;

    public EventRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(ConsumerRecord<String, String> record) {
        String event = record.value();
        mongoTemplate.save(event, COLLECTION_NAME);
    }
}
