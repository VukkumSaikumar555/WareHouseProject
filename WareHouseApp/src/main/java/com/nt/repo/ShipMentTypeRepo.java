package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.ShipmentType;

public interface ShipMentTypeRepo extends JpaRepository<ShipmentType, Integer> {
     
	@Query("SELECT id,ShipmentCode FROM ShipmentType WHERE EnableShipment='yes'")
	public List<Object[]> getShipmentTypeIdCode();
}
