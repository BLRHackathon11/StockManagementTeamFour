package com.ind.oms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ind.oms.repository.MessageRepository;



@RestController
public class KafkaRestController {

      @Autowired
      private MessageProducer producer;

      @Autowired
      private MessageRepository messageRepo;

      //Send message to kafka
      @GetMapping("/send")
      public String sendMsg(
      @RequestParam("msg") String message) {
          producer.sendMessage(message);
          return "+"+message+ " sent successfully!";
      }

      //Read all messages
      @GetMapping("/getAll")
      public String getAllMessages() {
         return messageRepo.getAllMessages() ;
      }
      
      
      //Send message to kafka
      @GetMapping("/placeOrder")
      public String sendOrder(
      @RequestParam("userId") int userId,@RequestParam("stockId") int stockId,@RequestParam("quantity") int quantity,boolean isBuy) {
         return  producer.placeOrder(userId,stockId,quantity,isBuy);
          
      }
      
      //view order
      @GetMapping("/viewOrder")
      public String viewOrder(
      @RequestParam("userId") int userId){
    	  return producer.viewOrdersbyUserId(userId);
    	  
      }
      
      

}