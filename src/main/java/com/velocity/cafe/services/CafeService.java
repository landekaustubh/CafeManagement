package com.velocity.cafe.services;

import java.util.List;

import com.velocity.cafe.entities.Cafe;

public interface CafeService {

	Cafe addCafe(Cafe cafe);

	List<Cafe> getCafeList(Cafe cafe);

	Cafe getCafeById(Long id);

	Cafe updateCafe(Cafe cafe, Long id);
	
}
