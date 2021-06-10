package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.PurchaseDtl;

public interface PurchaseDtlRepo extends JpaRepository<PurchaseDtl, Integer> {
	
	@Query("SELECT dtl FROM PurchaseDtl dtl INNER JOIN dtl.po as po WHERE po.id=:id")
	List<PurchaseDtl> getPurchaseDtlByOrderId(Integer id);

}
