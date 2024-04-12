package com.spring.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.spring.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	private final Payment payment;
	
	public PaymentService(Payment payment) {
		this.payment = payment;
	}
	
	public Payment getPayment(Long workerId, int days) {
		return new Payment("Bob", 200.00, days);
	}
}
