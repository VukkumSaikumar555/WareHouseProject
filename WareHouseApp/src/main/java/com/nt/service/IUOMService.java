package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.nt.model.UOM;

public interface IUOMService {

	UOM	saveRecord(UOM uom);
	List<UOM> getAllDetails();
	Optional<UOM> editRecord(Integer id);

	UOM	updateRecord(UOM UOM);
	void deleteOrder(Integer id);
	Map<Integer,String> getUomIdAndModel();
}
