package com.movies.movie.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.movie.models.movie;
import com.movies.movie.repositories.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @CrossOrigin
    @GetMapping
    public List<movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<movie> getMovieById(@PathVariable Long id) {
        Optional<movie> movie = movieRepository.findById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        // Si encuentra la movie restorna "ok". Sino retorna "notFound"
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<movie> createMovie(@RequestBody movie movie) {
        movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        if (!movieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<movie> updateMovie(@PathVariable Long id, @RequestBody movie updatedMovie){
        if (!movieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedMovie.setId(id);
        movie savedMovie = movieRepository.save(updatedMovie);
        return ResponseEntity.ok(savedMovie);
    }

    @CrossOrigin
    @GetMapping("/vote/{id}/{rating}")
    public ResponseEntity<movie> voteMovie(@PathVariable Long id, @PathVariable double rating){

        if (!movieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Optional<movie> optional= movieRepository.findById(id);
        movie movie = optional.get();

        double newRating = ((movie.getVotes() * movie.getRating()) + rating) / (movie.getVotes()+1);

        movie.setVotes(movie.getVotes()+1);
        movie.setRating(newRating);

        movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(savedMovie);
    }

}
