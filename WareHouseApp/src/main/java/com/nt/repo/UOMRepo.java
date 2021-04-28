package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.UOM;

public interface UOMRepo extends JpaRepository<UOM,Integer> {
	
	@Query("SELECT id,uomModel FROM UOM")
	List<Object[]> getUomIDAndModel();

}
