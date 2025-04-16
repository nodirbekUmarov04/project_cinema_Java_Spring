package com.example.cinema.controller;

import com.example.cinema.entity.Showtime;
import com.example.cinema.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    // Получить все шоу таймы
    @GetMapping
    public List<Showtime> getAllShowtimes() {
        return showtimeService.getAllShowtimes();
    }

    // Получить шоу тайм по ID
    @GetMapping("/{id}")
    public Optional<Showtime> getShowtimeById(@PathVariable Long id) {
        return showtimeService.getShowtimeById(id);
    }

    // Создать новый шоу тайм
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Showtime createShowtime(@RequestBody Showtime showtime) {
        return showtimeService.saveShowtime(showtime);
    }

    // Обновить существующий шоу тайм
    @PutMapping("/{id}")
    public Showtime updateShowtime(@PathVariable Long id, @RequestBody Showtime showtime) {
        return showtimeService.updateShowtime(id, showtime);
    }

    // Удалить шоу тайм по ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
    }
}