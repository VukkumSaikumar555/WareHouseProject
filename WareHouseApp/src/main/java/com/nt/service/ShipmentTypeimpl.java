package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.ShipmentType;
import com.nt.repo.ShipMentTypeRepo;

@Service
public class ShipmentTypeimpl implements IShipmentType {
	@Autowired
	private ShipMentTypeRepo repo;

	@Override
	public Integer saveShipmentType(ShipmentType st) {
		ShipmentType st1=repo.save(st);
		return st1.getId();
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		List<ShipmentType> listentities=repo.findAll();
		return listentities;
	}

	@Override
	public void deleteShipmentType(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public boolean isShipmentTypeExists(Integer id) {
	boolean flag=repo.existsById(id);
		return flag;
	}

	@Override
	public Optional<ShipmentType> getOneShipmentType(Integer id) {
	    Optional<ShipmentType> opt=repo.findById(id);
		return opt;
	}

	@Override
	public Integer UpdateShipMentType(ShipmentType ship) {
	  ShipmentType type=repo.save(ship);
		return type.getId();
		
	}

}
