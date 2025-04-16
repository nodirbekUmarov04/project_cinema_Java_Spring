package com.example.cinema.service;

import com.example.cinema.entity.Hall;
import com.example.cinema.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public Hall saveHall(Hall hall) {
        return hallRepository.save(hall);
    }

    public Optional<Hall> getHallById(Long id) {
        return hallRepository.findById(id);
    }

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();  // Получаем все залы
    }

    public Hall updateHall(Long id, Hall hall) {
        return hallRepository.findById(id)
                .map(existingHall -> {
                    existingHall.setName(hall.getName());
                    existingHall.setCapacity(hall.getCapacity());
                    existingHall.setSeats(hall.getSeats()); // если надо обновлять места
                    return hallRepository.save(existingHall);
                })
                .orElse(null);
    }


    public void deleteHall(Long id) {
        hallRepository.deleteById(id);
    }
}
