package com.example.cinema.controller;

import com.example.cinema.entity.Hall;
import com.example.cinema.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/halls")
@RequiredArgsConstructor
public class HallController {

    private final HallService hallService;

    // Получить все залы
    @GetMapping
    public List<Hall> getAllHalls() {
        return hallService.getAllHalls();
    }

    // Получить зал по ID
    @GetMapping("/{id}")
    public Optional<Hall> getHallById(@PathVariable Long id) {
        return hallService.getHallById(id);
    }

    // Создание нового зала
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hall createHall(@RequestBody Hall hall) {
        return hallService.saveHall(hall);
    }

    // Обновить существующий зал
    @PutMapping("/{id}")
    public Hall updateHall(@PathVariable Long id, @RequestBody Hall hall) {
        return hallService.updateHall(id, hall);
    }

    // Удалить зал
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHall(@PathVariable Long id) {
        hallService.deleteHall(id);
    }
}