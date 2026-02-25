package com.velocity.cafe.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.velocity.cafe.enums.Gender;
import com.velocity.cafe.enums.MembershipType;

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
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name" , length = 150 , nullable = false)
	private String firstName;
	
	@Column(name = "last_name" , length = 150 , nullable = false)
	private String lastName;
	
	@Column(name = "email" , length = 300 , unique = true)
	private String email;
	
	@Column(name = "mobile_no" , length = 300)
	private String phoneNumber;
	
	@Column(name = "gender" , length = 100)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "member_type" , length = 300)
	@Enumerated(EnumType.STRING)
	private MembershipType memberType;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> order;
}
