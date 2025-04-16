package com.example.cinema.controller;


import com.example.cinema.entity.Seat;
import com.example.cinema.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    // Получить все места
    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    // Получить место по ID
    @GetMapping("/{id}")
    public Optional<Seat> getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id);
    }

    // Создание нового места
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seat createSeat(@RequestBody Seat seat) {
        return seatService.saveSeat(seat);
    }

    // Обновить существующее место
    @PutMapping("/{id}")
    public Seat updateSeat(@PathVariable Long id, @RequestBody Seat seat) {
        return seatService.updateSeat(id, seat);
    }

    // Удалить место
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
    }
}