package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.nt.model.Parts;

public interface IPart {
	
	Integer savePart(Parts part);
	List<Parts> getallParts();
	void deletePart(Integer id);
    boolean isPartExist(Integer id);
    Optional<Parts> getOnePart(Integer id);
    Integer UpdatePart(Parts part);
    
    //integrations
    Map<Integer,String> getPartIdAndCode();
}
