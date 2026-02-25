package com.velocity.cafe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.velocity.cafe.enums.Category;

@Entity
@Table(name = "menuitems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private Double price;
	
	private Category category;
	
	@Column(name = "is_available")
	private Boolean isAvailable;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cafe_id", nullable = false)
	private Cafe cafe;
	
	@OneToMany(mappedBy = "menuItem")
	private List<OrderItem> orderItems;
}
