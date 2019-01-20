package br.com.zup.godfather.agent.utils;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.UUID;

public class ProducerManager {

    private static final String TOPIC = "events";

    private static Producer<String, String> PRODUCER;

    static {
        PRODUCER = ProducerFactory.create();
    }

    public static void send(String event) {
        final String key = UUID.randomUUID().toString();
        final ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, key, event);
        PRODUCER.send(record);
    }

}
