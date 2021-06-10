package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.PurchaseDtl;

public interface IPurchaseDtl extends JpaRepository<PurchaseDtl, Integer> {

}
