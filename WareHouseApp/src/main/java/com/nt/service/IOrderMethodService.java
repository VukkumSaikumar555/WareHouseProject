package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.nt.model.OrderMethod;

public interface IOrderMethodService {
	
OrderMethod	saveRecord(OrderMethod ordermethod);
List<OrderMethod> getAllDetails();
Optional<OrderMethod> editRecord(Integer id);

OrderMethod	updateRecord(OrderMethod ordermethod);
void deleteOrder(Integer id);

Map<Integer,String> getOrderMethodIdAndCode(String mode);
 
}
