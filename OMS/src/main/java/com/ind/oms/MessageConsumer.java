package com.ind.oms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ind.oms.repository.MessageRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MessageConsumer {

      private Logger log = LoggerFactory.getLogger(MessageConsumer.class);

      @Autowired
      private MessageRepository messageRepo;

      @KafkaListener(topics = "${myapp.kafka.topic}", groupId = "xyz")
      public void consume(String message) {
         log.info("ORDER RECEIVED AT CONSUMER END -> " + message);
         messageRepo.addMessage(message);
      }
  
}