package com.msdev.hrpayroll.services;

import com.msdev.hrpayroll.WorkerFeignCLient;
import com.msdev.hrpayroll.entities.Payment;
import com.msdev.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired
  private WorkerFeignCLient workerFeignCLient;

  public Payment getPayment(long workerId, int days) {

    Worker worker = workerFeignCLient.findbyId(workerId).getBody();
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
}
