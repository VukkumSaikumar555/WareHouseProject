package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.PurchaseOrder;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {
	
	@Query("UPDATE PurchaseOrder SET status=:status WHERE id=:id")
	@Modifying
	public void updateStatus(String status,Integer id);

}
