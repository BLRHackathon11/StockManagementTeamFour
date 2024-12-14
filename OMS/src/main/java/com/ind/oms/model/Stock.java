package com.ind.oms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long stockId;
	    
	    private String stockName;
	    private String stockQuantity;
	    private int price;
	    private String stockSymbol;
		public Long getStockId() {
			return stockId;
		}
		public void setStockId(Long stockId) {
			this.stockId = stockId;
		}
		public String getStockName() {
			return stockName;
		}
		public void setStockName(String stockName) {
			this.stockName = stockName;
		}
		public String getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(String stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getStockSymbol() {
			return stockSymbol;
		}
		public void setStockSymbol(String stockSymbol) {
			this.stockSymbol = stockSymbol;
		}
	    
	    

}
