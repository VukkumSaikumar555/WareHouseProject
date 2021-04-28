package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.WhUserType;
import com.nt.repo.WhUserTypeRepo;
@Service
public class WhUserTypeimpl implements IWhUserType {
	
	@Autowired
	private WhUserTypeRepo repo;

	@Override
	public Integer saveWhUserType(WhUserType st) {
		WhUserType st1=repo.save(st);
		return st1.getId();
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		List<WhUserType> entities=repo.findAll();
		return entities;
	}

	@Override
	public void deleteWhUserType(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public boolean isWhUserTypeExists(Integer id) {
		Boolean flag=repo.existsById(id);
		return flag;
	}

	@Override
	public Optional<WhUserType> getOneWhUserType(Integer id) {
		Optional<WhUserType> opt=repo.findById(id);
		return opt;
	}

	@Override
	public Integer UpdateWhUserType(WhUserType ship) {
		WhUserType user=repo.save(ship);
		return user.getId();
	}

	

	
}
