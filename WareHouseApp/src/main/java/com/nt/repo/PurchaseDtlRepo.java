package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.PurchaseDtl;

public interface PurchaseDtlRepo extends JpaRepository<PurchaseDtl, Integer> {
	
	@Query("SELECT dtl FROM PurchaseDtl dtl INNER JOIN dtl.po as po WHERE po.id=:id")
	List<PurchaseDtl> getPurchaseDtlByOrderId(Integer id);
    
	@Query("SELECT COUNT(*) FROM PurchaseDtl WHERE part.id=:id1 and po.id=:id2")
	Integer CountPurchaseDtl(Integer id1,Integer id2);
	
	@Query("SELECT COUNT(dtl.id) FROM PurchaseDtl dtl INNER JOIN dtl.po as po WHERE po.id=:id ")
	Integer getCountofOrderId(Integer id);
	
	
}
