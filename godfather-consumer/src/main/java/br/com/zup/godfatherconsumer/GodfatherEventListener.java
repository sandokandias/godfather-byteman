package br.com.zup.godfatherconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class GodfatherEventListener {

    private final EventRepository eventRepository;

    public GodfatherEventListener(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @KafkaListener(topics = "events", groupId = "godfather-consumer-events")
    public void listen(ConsumerRecord<String, String> record) throws Exception {
        System.out.println("CONSUMER consuming event = " + record.key() + " from topic = " + record.topic());
        eventRepository.save(record);
    }
}
