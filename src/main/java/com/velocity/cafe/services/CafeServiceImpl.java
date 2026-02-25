package com.velocity.cafe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.velocity.cafe.entities.Cafe;
import com.velocity.cafe.repositories.CafeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CafeServiceImpl implements CafeService{

	private final CafeRepository cafeRepository;

	@Override
	public Cafe addCafe(Cafe cafe) {
		Cafe c1 = cafeRepository.save(cafe);
		return c1;
	}

	@Override
	public List<Cafe> getCafeList(Cafe cafe) {
		List<Cafe> list = cafeRepository.findAll();
		return list;
	}

	@Override
	public Cafe getCafeById(Long id) {
		Optional<Cafe> ci1 = cafeRepository.findById(id);
		return ci1.orElse(null);
	}

	@Override
	public Cafe updateCafe(Cafe cafe, Long id) {
		cafe.setId(id);
		Cafe update = cafeRepository.save(cafe);
		return update;
	}
	

}
