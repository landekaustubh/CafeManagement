package com.velocity.cafe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.cafe.entities.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Long>{

}
