package com.msdev.hrpayroll.controllers;

import com.msdev.hrpayroll.entities.Payment;
import com.msdev.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @Autowired
    private CircuitBreakerFactory<?, ?> circuitBreakerFactory;

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        // Payment payment = service.getPayment(workerId, days);

        Payment payment = circuitBreakerFactory.create("paymentService").run(
                () -> service.getPayment(workerId, days),
                throwable -> fallbackPayment(workerId, days, throwable)
        );

        return ResponseEntity.ok(payment);
    }

    public Payment fallbackPayment(Long workerId, Integer days, Throwable throwable) {
        return new Payment("Fallback Worker", 400.0, days);
    }
}
