package com.example.cinema.service;

import com.example.cinema.entity.Booking;
import com.example.cinema.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Long id, Booking booking) {
        return bookingRepository.findById(id)
                .map(existingBooking -> {
                    existingBooking.setUser(booking.getUser());
                    existingBooking.setShowtime(booking.getShowtime());
                    existingBooking.setSeat(booking.getSeat());
                    return bookingRepository.save(existingBooking);
                })
                .orElse(null);
    }


    public void deleteBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Booking not found for id: " + id);
        }
    }
}