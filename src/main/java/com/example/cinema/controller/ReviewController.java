package com.example.cinema.controller;


import com.example.cinema.entity.Review;
import com.example.cinema.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // Получить все отзывы
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Получить отзыв по ID
    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    // Создание нового отзыва
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    // Обновить существующий отзыв
    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    // Удалить отзыв
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}