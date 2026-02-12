package com.example.movieapi.controller;

import com.example.movieapi.model.Movie;
import com.example.movieapi.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {

        // Input validation
        if (movie.getName() == null || movie.getName().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Movie name is required");
        }

        if (movie.getRating() < 0 || movie.getRating() > 10) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Rating must be between 0 and 10");
        }

        Movie savedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    // Get movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {

        if (movieService.getMovieById(id).isPresent()) {
            return ResponseEntity.ok(movieService.getMovieById(id).get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Movie not found");
        }
    }

}
