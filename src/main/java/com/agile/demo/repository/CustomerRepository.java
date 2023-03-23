package com.agile.demo.repository;

import com.agile.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
