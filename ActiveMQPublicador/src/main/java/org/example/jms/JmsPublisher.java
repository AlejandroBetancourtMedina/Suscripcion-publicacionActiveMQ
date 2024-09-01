package org.example.jms;

import org.example.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsPublisher {
    @Autowired
    JmsTemplate jmsTemplate;
    @Value("jsa-topic")
    String topic;

    public void send (Company apple){
        jmsTemplate.convertAndSend(topic, apple);
    }
}
