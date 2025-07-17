package com.github.douglashauschild.hexagonalapi.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.douglashauschild.hexagonalapi.domain.model.Customer;
import com.github.douglashauschild.hexagonalapi.domain.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
