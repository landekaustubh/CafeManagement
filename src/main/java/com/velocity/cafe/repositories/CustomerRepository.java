package com.velocity.cafe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.cafe.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
