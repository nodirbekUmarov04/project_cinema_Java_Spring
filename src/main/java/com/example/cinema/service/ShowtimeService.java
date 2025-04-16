package com.example.cinema.service;

import com.example.cinema.entity.Showtime;
import com.example.cinema.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    // Обновить существующий шоу тайм
    public Showtime updateShowtime(Long id, Showtime showtime) {
        Optional<Showtime> existingShowtime = showtimeRepository.findById(id);
        if (existingShowtime.isPresent()) {
            Showtime updatedShowtime = existingShowtime.get();
            updatedShowtime.setMovie(showtime.getMovie());
            updatedShowtime.setHall(showtime.getHall());
            updatedShowtime.setStartTime(showtime.getStartTime());
            updatedShowtime.setEndTime(showtime.getEndTime());
            return showtimeRepository.save(updatedShowtime);
        } else {
            throw new RuntimeException("Showtime not found with ID: " + id);
        }
    }
}
