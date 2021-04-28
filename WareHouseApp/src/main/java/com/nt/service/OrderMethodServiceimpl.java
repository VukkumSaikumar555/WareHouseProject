package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.OrderMethod;
import com.nt.repo.OrderMethodRepo;
import com.nt.util.CollectionUtil;
@Service
public class OrderMethodServiceimpl implements IOrderMethodService {
	@Autowired
	private OrderMethodRepo repo;
	
	
	@Override
	public OrderMethod saveRecord(OrderMethod ordermethod) {
		 OrderMethod order=repo.save(ordermethod);
		return order;
	}

	@Override
	public List<OrderMethod> getAllDetails() {
		List<OrderMethod> list=repo.findAll();
		return list;
	}

	

	@Override
	public Optional<OrderMethod> editRecord(Integer id) {
	    Optional<OrderMethod> opt=repo.findById(id);
		return opt;
	}

	

	@Override
	public OrderMethod updateRecord(OrderMethod ordermethod) {
		OrderMethod entity=repo.save(ordermethod);
		return entity;
	}

	@Override
	public void deleteOrder(Integer id) {
		repo.deleteById(id);
		
		
	}

	@Override
	public Map<Integer, String> getOrderMethodIdAndCode(String mode) {
		List<Object[]> list=repo.getSaleIDAndMode(mode);
		Map<Integer, String> map=CollectionUtil.convertToMap(list);
		return map;
	}
	
	

}
