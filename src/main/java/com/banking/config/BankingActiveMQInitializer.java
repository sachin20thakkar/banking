package com.banking.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class BankingActiveMQInitializer {


    @Bean
    public ConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDefaultDestination(new ActiveMQQueue("jms.queue"));
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory());
        return jmsTemplate;
    }

    @Bean
    public JmsTemplate queueJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDefaultDestination(new ActiveMQQueue("jms.queue"));
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory());
        jmsTemplate.setMessageConverter(jacksonMessageConverter());
        return jmsTemplate;
    }

    @Bean
    public MessageConverter jacksonMessageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        mappingJackson2MessageConverter.setTypeIdPropertyName("_messageType");
        return mappingJackson2MessageConverter;
    }

}
