package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.UOM;
import com.nt.repo.UOMRepo;
import com.nt.util.CollectionUtil;
@Service
public class UOMimpl implements IUOMService {
	@Autowired
	private UOMRepo repo;

	@Override
	public UOM saveRecord(UOM uom) {
		UOM uom1=repo.save(uom);
		return uom1;
	}

	@Override
	public List<UOM> getAllDetails() {
		List<UOM> list=repo.findAll();
		return list;
	}

	@Override
	public Optional<UOM> editRecord(Integer id) {
		Optional<UOM> opt=repo.findById(id);
		
		return opt;
	}

	@Override
	public UOM updateRecord(UOM uom) {
		UOM uom1=repo.save(uom);
		return uom1;
	}

	@Override
	public void deleteOrder(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Map<Integer, String> getUomIdAndModel() {
		List<Object[]> list=repo.getUomIDAndModel();
		Map<Integer,String> map =CollectionUtil.convertToMap(list);
		return map;
	}

}
