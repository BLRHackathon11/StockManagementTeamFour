package com.ind.oms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

private Logger log =LoggerFactory.getLogger(MessageProducer.class);

      @Autowired 
      private KafkaTemplate<String, String> kafkaTemplate;

      @Value("${myapp.kafka.topic}")
      private String topic;

      public void sendMessage(String message) {
         log.info("MESSAGE SENT FROM PRODUCER END -> " + message);
         kafkaTemplate.send(topic, message);
      }
      
      public String placeOrder(int userId,int stockId,int Quantity,Boolean isBuy) {
          log.info("user "+userId+"placed an order for the number of stock with name ");
          String message="";
          if(isBuy)
          {
          message  = "user "+userId+"bought an order for the number"+Quantity+" of stock with Id "+stockId;
          }
          else
          {
          message= "user"+userId+"sold an order for the number"+Quantity+" of stock with Id "+stockId;
          }
          kafkaTemplate.send(topic, message);
          return message;
         
       }
      
      public String viewOrdersbyUserId(int userId) {
          log.info("returning all the orders for "+userId);
          String message  = "returning all the orders for "+userId;
          kafkaTemplate.send(topic, message);
          return "\"returning all the orders for "+userId;
       }
      
}