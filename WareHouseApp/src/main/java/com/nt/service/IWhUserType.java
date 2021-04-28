package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.model.WhUserType;



public interface IWhUserType {
	
	Integer saveWhUserType(WhUserType st);
	List<WhUserType> getAllWhUserTypes();
	void deleteWhUserType(Integer id);
	boolean isWhUserTypeExists(Integer id);
	Optional<WhUserType> getOneWhUserType(Integer id);
	Integer UpdateWhUserType(WhUserType ship);

}
