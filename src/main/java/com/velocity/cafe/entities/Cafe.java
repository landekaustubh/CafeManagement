package com.velocity.cafe.entities;

import java.time.LocalTime;
import java.util.List;

import com.velocity.cafe.enums.CafeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cafes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cafe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String location;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "opening_time")
	private LocalTime openingTime;
	
	@Column(name = "closing_time")
	private LocalTime closingTime;
	
	@Column(name = "cafe_type")
	@Enumerated(EnumType.STRING)
	private CafeType cafeType;
	
	private Double rating;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@OneToMany(mappedBy = "cafe")
	private List<MenuItem> menuItem;
}
