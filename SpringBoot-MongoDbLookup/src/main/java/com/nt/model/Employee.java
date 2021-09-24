package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee {
    @Id    
	private Integer empid;
    private String name;
    private Double sal;
    
    private Set<String> empPrjs; 
	private List<String> empPrjVer;
	private String[] empGrades;
	
	private Map<String,String> empClient;
	@DBRef
	private Address addr;//HAS-A
	@DBRef
	private List<Department> dobs;
  
        
}//class
