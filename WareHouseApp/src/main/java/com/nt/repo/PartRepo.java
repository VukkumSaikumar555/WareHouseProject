package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.Parts;

public interface PartRepo extends JpaRepository<Parts, Integer> {
	
	@Query("SELECT id,partcode FROM Parts")
	public List<Object[]> getPartsIdAndCode();

}
