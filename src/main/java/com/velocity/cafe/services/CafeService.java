package com.velocity.cafe.services;

import java.util.List;

import com.velocity.cafe.dto.request.CafeRequestDto;
import com.velocity.cafe.dto.response.CafeResponseDto;
import com.velocity.cafe.entities.Cafe;

public interface CafeService {

	CafeResponseDto addCafe(CafeRequestDto cafe);

	List<CafeResponseDto> getCafeList();

	CafeResponseDto getCafeById(Long id);

	CafeResponseDto updateCafe(CafeRequestDto cafe, Long id);

	CafeResponseDto updateCafeName(Long id, String name);

	void deleteCafeById(Long id);
	
}
