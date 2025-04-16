package com.example.cinema.service;


import com.example.cinema.entity.Seat;
import com.example.cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Optional<Seat> getSeatById(Long id) {
        return seatRepository.findById(id);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat updateSeat(Long id, Seat seat) {
        return seatRepository.findById(id)
                .map(existingSeat -> {
                    existingSeat.setHall(seat.getHall());
                    existingSeat.setRowNumber(seat.getRowNumber());
                    existingSeat.setSeatNumber(seat.getSeatNumber());
                    return seatRepository.save(existingSeat);
                })
                .orElse(null);
    }


    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }
}