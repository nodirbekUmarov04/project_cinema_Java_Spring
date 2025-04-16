package com.example.cinema.service;

import com.example.cinema.entity.Showtime;
import com.example.cinema.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    public Showtime saveShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public Optional<Showtime> getShowtimeById(Long id) {
        return showtimeRepository.findById(id);
    }

    public void deleteShowtime(Long id) {
        showtimeRepository.deleteById(id);
    }

}