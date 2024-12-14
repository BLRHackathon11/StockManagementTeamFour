package com.ind.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ind.oms.model.*;

public interface StockRepository extends JpaRepository<Stock, Long>{
	

}
