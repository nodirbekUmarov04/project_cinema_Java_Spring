package com.example.cinema.service;


import com.example.cinema.entity.Payment;
import com.example.cinema.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();  // Получение всех платежей
    }

    public Payment updatePayment(Long id, Payment payment) {
        if (paymentRepository.existsById(id)) {
            // Получаем существующую запись по id
            Payment existingPayment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));

            // Обновляем все необходимые поля
            existingPayment.setBooking(payment.getBooking());
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setStatus(payment.getStatus());

            return paymentRepository.save(existingPayment);
        } else {
            return null;  // Возвращаем null, если запись не найдена
        }
    }


    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}