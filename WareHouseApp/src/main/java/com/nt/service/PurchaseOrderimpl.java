package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.PurchaseOrder;
import com.nt.repo.PurchaseOrderRepo;

@Service
public class PurchaseOrderimpl implements IPurchaseOrder {
     
	@Autowired
	private PurchaseOrderRepo repo;
	
	@Override
	public PurchaseOrder savePO(PurchaseOrder po) {
		PurchaseOrder ord=repo.save(po);
		return ord;
	}

	@Override
	public List<PurchaseOrder> getAllRecord() {
		List<PurchaseOrder> listpo=repo.findAll();
		return listpo;
	}

}
