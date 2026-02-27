package com.velocity.cafe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.velocity.cafe.dto.request.CafeRequestDto;
import com.velocity.cafe.dto.response.CafeResponseDto;
import com.velocity.cafe.entities.Cafe;
import com.velocity.cafe.mapper.CafeMapper;
import com.velocity.cafe.repositories.CafeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CafeServiceImpl implements CafeService{

	private final CafeRepository cafeRepository;
	private final CafeMapper cafeMapper;

	@Override
	public CafeResponseDto addCafe(CafeRequestDto cafe) {
		Cafe c1  = cafeRepository.save(cafeMapper.toEntity(cafe));
		return cafeMapper.toDto(c1);
		
	}

	@Override
	public List<CafeResponseDto> getCafeList() {
		return cafeMapper.list(cafeRepository.findAll());
	}

	@Override
	public CafeResponseDto getCafeById(Long id) {
		Cafe ci1 = cafeRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		return cafeMapper.toDto(ci1);
	}

	@Override
	public CafeResponseDto updateCafe(CafeRequestDto cafe, Long id) {
		Cafe existingCafe = cafeRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Cafe not found"));

		cafeMapper.updateCafeFromDto(cafe, existingCafe);

		Cafe updatedCafe = cafeRepository.save(existingCafe);
		
		  return cafeMapper.toDto(updatedCafe);
		
	}

	@Override
	public CafeResponseDto updateCafeName(Long id, String name) {
		Optional<Cafe> optinalCafe = cafeRepository.findById(id);
		if(optinalCafe.isPresent()) {
			Cafe cafe = optinalCafe.get();
			cafe.setName(name);
			Cafe updatedCafe = cafeRepository.save(cafe);
			return cafeMapper.toDto(updatedCafe);
		}
		else {
			throw new RuntimeException("Cafe Name has not changed");
		}
	}

	@Override
	public void deleteCafeById(Long id) {
		cafeRepository.deleteById(id);
	}
	

}
