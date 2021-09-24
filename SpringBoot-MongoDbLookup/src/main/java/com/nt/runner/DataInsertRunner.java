package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.model.Address;
import com.nt.model.Department;
import com.nt.model.Employee;
import com.nt.repo.AddressRepo;
import com.nt.repo.DepartmentRepo;
import com.nt.repo.EmployeeRepo;
@Component
@Order(1)
public class DataInsertRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepo repo;
	@Autowired
	private DepartmentRepo drepo;
	@Autowired
	private AddressRepo arepo;

	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		drepo.deleteAll();
		arepo.deleteAll();
		
		Address add=new Address(55,"7520/A","Secunderabad",500031L);
		arepo.save(add);
	
		List<Department> dept=List.of(new Department(11,"D1","DEV-AB"),new Department(12,"D2","QA-RB"),new Department(13,"D3","SUPRIT-MN"));
		drepo.saveAll(dept);
		
		repo.save(new Employee(555,"Karan",25000.0,Set.of("HTC","NIT","ORCL"),
				           List.of("3.2GA","6.5 RELEASE","0.1 RELEASE")
				          ,new String[] {"A+","GR-T","UI-NEW"},
				          Map.of("C1","Tech-N","C2","US-Army","C3","WareHouse"),
				          add,dept
				));
	
	
	
	
	}//run(-)

}//class
