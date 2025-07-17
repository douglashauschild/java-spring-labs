package com.github.douglashauschild.hexagonalapi.domain.repository;

import java.util.List;
import java.util.Optional;

import com.github.douglashauschild.hexagonalapi.domain.model.Customer;

public interface CustomerRepository {
    
	Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    List<Customer> findAll();
}
