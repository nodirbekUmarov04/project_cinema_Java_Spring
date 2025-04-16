package com.example.cinema.service;

import com.example.cinema.entity.Review;
import com.example.cinema.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review updateReview(Long id, Review review) {
        return reviewRepository.findById(id)
                .map(existingReview -> {
                    existingReview.setRating(review.getRating());
                    existingReview.setComment(review.getComment());
                    existingReview.setUser(review.getUser());
                    existingReview.setMovie(review.getMovie());
                    return reviewRepository.save(existingReview);
                })
                .orElse(null);
    }


    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}