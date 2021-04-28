package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.PurchaseOrder;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {

}
