package com.velocity.cafe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.cafe.entities.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{

}
