package com.velocity.cafe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.cafe.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
