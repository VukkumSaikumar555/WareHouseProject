package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.model.PurchaseDtl;
import com.nt.model.PurchaseOrder;
import com.nt.repo.PurchaseDtlRepo;
import com.nt.repo.PurchaseOrderRepo;

@Service
public class PurchaseOrderimpl implements IPurchaseOrder {
     
	@Autowired
	private PurchaseOrderRepo repo;
	

	
	@Autowired
	private PurchaseDtlRepo detail;
	
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

	@Override
	public PurchaseOrder getPurchaseOrder(Integer id) {
	Optional<PurchaseOrder> opt=repo.findById(id);
	PurchaseOrder po=opt.get();
		return po;
	}

	@Override
	public Integer addParts(PurchaseDtl dtl) {
		PurchaseDtl dtl1=detail.save(dtl);
		return dtl1.getPo().getId();
	}

	@Override
	public List<PurchaseDtl> getPurchaseDtlByOrderId(Integer id) {
		
		return detail.getPurchaseDtlByOrderId(id);
	}

	@Override
	public void DeletePurchaseDtl(Integer id) {
		detail.deleteById(id);
		
	}

	@Override
	public Integer CountPurchaseDtl(Integer id1, Integer id2) {
		Integer i=detail.CountPurchaseDtl(id1, id2);
		return i;
	}

	@Transactional
	public void updateStatus(String status, Integer id) {
		repo.updateStatus(status, id);
		
	}

	@Override
	public Integer getCountofOrderId(Integer id) {
		Integer id1=detail.getCountofOrderId(id);
		return id1;
	}

}
