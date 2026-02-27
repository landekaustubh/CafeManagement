package com.velocity.cafe.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.cafe.dto.request.CafeRequestDto;
import com.velocity.cafe.dto.response.CafeResponseDto;
import com.velocity.cafe.entities.Cafe;
import com.velocity.cafe.services.CafeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cafes")
public class CafeController {

	private final CafeService cafeService;
	
	@PostMapping
	public ResponseEntity<CafeResponseDto> createCafe(@RequestBody @Valid CafeRequestDto cafe){
		CafeResponseDto cafe1 = cafeService.addCafe(cafe);
		return ResponseEntity.status(HttpStatus.CREATED).body(cafe1);
	}
	
	@GetMapping
	public ResponseEntity<List<CafeResponseDto>> getAllCafe(){
		List<CafeResponseDto> list1 = cafeService.getCafeList();
        return ResponseEntity.status(HttpStatus.OK).body(list1);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CafeResponseDto> getCafe(@PathVariable Long id){
		CafeResponseDto cafeId = cafeService.getCafeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cafeId);
	}
	
	@PutMapping("/{cafeId}")
	public ResponseEntity<CafeResponseDto> updateCafe(
	        @Valid @RequestBody CafeRequestDto cafe,
	        @PathVariable("cafeId") Long id) {

	    CafeResponseDto updCafe = cafeService.updateCafe(cafe, id);

	    return ResponseEntity.ok(updCafe);
	}
	
	@PatchMapping("/{id}/name")
	public ResponseEntity<CafeResponseDto> updateCafeName(@PathVariable Long id, @RequestParam String name){
		CafeResponseDto c1 =	cafeService.updateCafeName(id,name);
	  return ResponseEntity.status(HttpStatus.OK).body(c1);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCafe(@PathVariable Long id){
		cafeService.deleteCafeById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
