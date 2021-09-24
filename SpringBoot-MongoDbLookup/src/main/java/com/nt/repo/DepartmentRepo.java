package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.model.Department;

public interface DepartmentRepo extends MongoRepository<Department, Integer> {

}
