package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.model.Address;

public interface AddressRepo extends MongoRepository<Address, Integer> {

}
