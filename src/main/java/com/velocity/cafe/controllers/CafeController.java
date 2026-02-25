package com.velocity.cafe.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.cafe.entities.Cafe;
import com.velocity.cafe.services.CafeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cafes")
public class CafeController {

	private final CafeService cafeService;
	
	@PostMapping
	public ResponseEntity<Cafe> createCafe(@RequestBody Cafe cafe){
		Cafe cafe1 = cafeService.addCafe(cafe);
		if(cafe1 != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(cafe1);
		}
		return null;
	}
	
	@GetMapping
	public ResponseEntity<List<Cafe>> getAllCafe(Cafe cafe){
		List<Cafe> list1 = cafeService.getCafeList(cafe);
		if(list1 != null) {
			return ResponseEntity.status(HttpStatus.OK).body(list1);
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cafe> getCafe(@PathVariable Long id){
		Cafe cafeId = cafeService.getCafeById(id);
		if(cafeId != null) {
			return ResponseEntity.status(HttpStatus.OK).body(cafeId);
		}
		return null;
	}
	
	@PutMapping("/{cafeId}")
	public ResponseEntity<Cafe> updateCafe(@RequestBody Cafe cafe, @PathVariable(name = "cafeId") Long id){
		Cafe updCafe = cafeService.updateCafe(cafe,id);
	    if(cafe != null) {
	    	return ResponseEntity.status(HttpStatus.OK).body(updCafe);
	    }
	    return null;
	}
}
