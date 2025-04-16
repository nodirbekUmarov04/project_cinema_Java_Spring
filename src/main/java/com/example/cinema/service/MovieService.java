package com.example.cinema.service;

import com.example.cinema.entity.Movie;
import com.example.cinema.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie updateMovie(Long id, Movie movie) {
        if (movieRepository.existsById(id)) {
            // Получаем существующий объект по id
            Movie existingMovie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

            existingMovie.setTitle(movie.getTitle());
            existingMovie.setDescription(movie.getDescription());
            existingMovie.setReleaseDate(movie.getReleaseDate());
            existingMovie.setGenre(movie.getGenre());
            existingMovie.setDurationMinutes(movie.getDurationMinutes());

            // Сохраняем обновлённый объект
            return movieRepository.save(existingMovie);
        }
        return null;  // Если фильм не найден
    }


    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
