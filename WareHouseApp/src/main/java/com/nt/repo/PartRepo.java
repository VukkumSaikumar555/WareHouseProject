package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Parts;

public interface PartRepo extends JpaRepository<Parts, Integer> {

}
