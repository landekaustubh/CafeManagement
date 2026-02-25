package com.velocity.cafe.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.velocity.cafe.enums.OrderStatus;
import com.velocity.cafe.enums.PaymentMethod;

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

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "order_date")
	private LocalDateTime orderdate;
	
	@Column(name = "total_amount")
	private Double totalAmount;
	
	@Column(name = "order_status")
	private OrderStatus orderStatus;
	
	@Column(name = "payment_method")
	private PaymentMethod paymentMethod;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItem;
}
