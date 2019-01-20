package br.com.zup.godfather.agent.utils;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public class ProducerFactory {

    public static Producer<String, String> create() {
        Properties config = new Properties();
        config.put("client.id", "godfather-agent");
        config.put("bootstrap.servers", "127.0.0.1:9092");
        config.put("acks", "all");
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(config);
    }
}
