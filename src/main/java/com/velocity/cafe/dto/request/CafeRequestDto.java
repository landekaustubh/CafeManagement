package com.velocity.cafe.dto.request;

import java.time.LocalTime;
import java.util.List;


import com.velocity.cafe.entities.MenuItem;
import com.velocity.cafe.enums.CafeType;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CafeRequestDto {
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank
	private String location;
	
	@NotBlank(message = "Add 10 digit number")
	@Size(min = 10 , max = 10)
	private String phoneNumber;

	private LocalTime openingTime;

	private LocalTime closingTime;
	
	private CafeType cafeType;
	
	@Min(0)
	@Max(5)
	private Double rating;
	
	private Boolean isActive;
	
	private List<MenuItem> menuItems;
}
