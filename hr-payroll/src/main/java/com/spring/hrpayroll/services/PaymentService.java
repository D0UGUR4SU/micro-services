package com.spring.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hrpayroll.entities.Payment;
import com.spring.hrpayroll.entities.Worker;
import com.spring.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	private final WorkerFeignClient workerFeignClient;

	@Autowired
	public PaymentService(WorkerFeignClient workerFeignClient) {
		this.workerFeignClient = workerFeignClient;
	}

	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker != null ? worker.getName() : null, worker != null ? worker.getDailyIncome() : null, days);
	}
}
