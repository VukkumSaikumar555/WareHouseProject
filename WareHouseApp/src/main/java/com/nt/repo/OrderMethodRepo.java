package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.OrderMethod;

public interface OrderMethodRepo extends JpaRepository<OrderMethod, Integer> {
	
	
	 List<OrderMethod> findAll() ;
	
	 @Query("SELECT  id,OrderCode FROM  OrderMethod WHERE OrderMode=:mode")
	 List<Object[]> getSaleIDAndMode(String mode);
	

}
