package com.ecommer.userservices.kafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerClinet {
    private final KafkaTemplate<String,String> kafkaTemplate;
@Autowired
    public KafkaProducerClinet(KafkaTemplate<String, String> kafkaTemplate) {// contructor
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String topic, String message){// setting up topic and message for kafka starting
        System.out.println("SENDING MESSAGE TO KAFKA "+message);
        kafkaTemplate.send(topic,message);
        System.out.println("email sent "+topic);// log to confirm
    }
}
