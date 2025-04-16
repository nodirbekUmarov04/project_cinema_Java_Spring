package com.example.cinema.service;


import com.example.cinema.entity.Hall;
import com.example.cinema.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteHall(Long id) {
        hallRepository.deleteById(id);
    }

}