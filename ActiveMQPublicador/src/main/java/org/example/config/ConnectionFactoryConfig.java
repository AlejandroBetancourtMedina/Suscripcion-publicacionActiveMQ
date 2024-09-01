package org.example.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class ConnectionFactoryConfig {
@Value("tcp://localhost:61616")
    String brokerUrl;
@Value("admin")
    String userName;
@Value("admin")
    String password;

@Bean
public ConnectionFactory connectionFactory(){
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setBrokerURL(brokerUrl);
    connectionFactory.setUserName(userName);
    connectionFactory.setPassword(password);
    return connectionFactory;
}
@Bean
public MessageConverter jacksonJmsMessageConverter(){
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_type");
    return converter;
}
@Bean
public JmsTemplate jmsTemplate(){
JmsTemplate template = new JmsTemplate();
template.setConnectionFactory(connectionFactory());
template.setMessageConverter(jacksonJmsMessageConverter());
template.setPubSubDomain(true);
return template;
}
}
