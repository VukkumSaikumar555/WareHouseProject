package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.nt.model.Address;
import com.nt.model.Department;
import com.nt.model.Employee;
import com.nt.model.MyResult;
import com.nt.repo.AddressRepo;
import com.nt.repo.DepartmentRepo;
import com.nt.repo.EmployeeRepo;
@Component
@Order(2)
public class DataFetchRunner implements CommandLineRunner {
	@Autowired
	private MongoTemplate mt;
	

	@Override
	public void run(String... args) throws Exception {
		Aggregation aggr=Aggregation.newAggregation(
				                       Aggregation.match(Criteria.where("_id").is(555)),
				                       Aggregation.sort(Direction.ASC,"name"),
				                       Aggregation.project("name","addr","dobs")
				);
		
		
		//List<Employee> list= mt.aggregate(aggr, "employee",Employee.class).getRawResults();
		Docum list= mt.aggregate(aggr, "employee",Employee.class).getRawResults();
				                           
	  list.forEach(ob->System.out.println(ob));
	
	}//run(-)

}//class
