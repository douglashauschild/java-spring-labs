package com.github.douglashauschild.hexagonalapi.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.douglashauschild.hexagonalapi.infrastructure.persistence.entity.CustomerEntity;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
}
