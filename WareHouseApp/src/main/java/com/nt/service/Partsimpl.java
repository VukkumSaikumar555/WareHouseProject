package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Parts;
import com.nt.repo.PartRepo;
@Service
public class Partsimpl implements IPart {
	
	@Autowired
	private PartRepo repo;

	@Override
	public Integer savePart(Parts part) {
		Parts part1=repo.save(part);
		return part1.getId();
	}

	@Override
	public List<Parts> getallParts() {
		List<Parts> list=repo.findAll();
		return list;
	}

	@Override
	public void deletePart(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public boolean isPartExist(Integer id) {
		boolean flag=repo.existsById(id);
		return flag;
	}

	@Override
	public Optional<Parts> getOnePart(Integer id) {
		Optional<Parts> opt=repo.findById(id);
		return opt;
	}

	@Override
	public Integer UpdatePart(Parts part) {
		Parts part1=repo.save(part);
		return part1.getId();
	}

}
