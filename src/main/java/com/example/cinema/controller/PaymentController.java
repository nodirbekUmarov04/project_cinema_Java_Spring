package com.example.cinema.controller;


import com.example.cinema.entity.Payment;
import com.example.cinema.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    // Получить все платежи
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Получить платеж по ID
    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // Создание нового платежа
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    // Обновить существующий платеж
    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    // Удалить платеж
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}