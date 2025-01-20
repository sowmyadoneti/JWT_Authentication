package com.example.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Productentity, Integer>{

	List<Productentity> findByIsdeletedFalse();

}
