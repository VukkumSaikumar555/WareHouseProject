package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.nt.model.ShipmentType;

public interface IShipmentType {
	
	Integer saveShipmentType(ShipmentType st);
	List<ShipmentType> getAllShipmentTypes();
	void deleteShipmentType(Integer id);
	boolean isShipmentTypeExists(Integer id);
	Optional<ShipmentType> getOneShipmentType(Integer id);
	Integer UpdateShipMentType(ShipmentType ship);
	//module integration
	Map<Integer,String> getShipmentTypeIdCode();

}
