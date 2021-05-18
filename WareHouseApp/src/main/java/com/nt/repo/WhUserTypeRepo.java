package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.WhUserType;

public interface WhUserTypeRepo extends JpaRepository<WhUserType,Integer> {
	
	 @Query("SELECT id,usercode FROM WhUserType WHERE usertype=:usertype")
     public List<Object[]> getIdAndCodeByType(String usertype);
	
}
