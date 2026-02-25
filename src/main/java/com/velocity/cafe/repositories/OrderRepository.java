package com.velocity.cafe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.cafe.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
