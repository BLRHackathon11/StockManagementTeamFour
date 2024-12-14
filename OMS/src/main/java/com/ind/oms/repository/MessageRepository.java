package com.ind.oms.repository;



import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
	
	 private List<String> list = new ArrayList<>();
	  
	  public void  addMessage(String message) { list.add(message); }
	  
	  public String  getAllMessages() { return list.toString(); }
	 
	
}