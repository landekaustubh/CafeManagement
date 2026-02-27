package com.velocity.cafe.dto.response;

import java.time.LocalTime;
import java.util.List;

import com.velocity.cafe.entities.MenuItem;
import com.velocity.cafe.enums.CafeType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CafeResponseDto {
	
	private Long cafeId;
	
	private String name;
	
	private String location;
	
	private String phoneNumber;
	
	private LocalTime openingTime;
	
	private LocalTime closingTime;
	
	private CafeType cafeType;
	
	private Double rating;
	
	private Boolean isActive;
	
	private List<MenuItem> menuItems;
}
