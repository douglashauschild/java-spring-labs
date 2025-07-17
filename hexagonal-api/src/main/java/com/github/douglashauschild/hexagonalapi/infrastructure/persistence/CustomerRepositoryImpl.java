package com.github.douglashauschild.hexagonalapi.infrastructure.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.github.douglashauschild.hexagonalapi.domain.model.Customer;
import com.github.douglashauschild.hexagonalapi.domain.repository.CustomerRepository;
import com.github.douglashauschild.hexagonalapi.infrastructure.persistence.entity.CustomerEntity;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = new CustomerEntity(null, customer.getName(), customer.getEmail());
        CustomerEntity saved = customerJpaRepository.save(entity);
        return new Customer(saved.getId(), saved.getName(), saved.getEmail());
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerJpaRepository.findById(id).map(e -> new Customer(e.getId(), e.getName(), e.getEmail()));
    }

    @Override
    public List<Customer> findAll() {
        return customerJpaRepository.findAll()
                .stream()
                .map(e -> new Customer(e.getId(), e.getName(), e.getEmail()))
                .collect(Collectors.toList());
    }
}
