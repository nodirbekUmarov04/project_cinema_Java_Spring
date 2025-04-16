package com.example.cinema.controller;


import com.example.cinema.entity.Booking;
import com.example.cinema.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // Получение всех бронирований
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Получение бронирования по ID
    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    // Создание нового бронирования
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    // Обновление информации о бронировании
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    // Удаление бронирования
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}