package com.movies.movie.repositories;

import com.movies.movie.models.movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<movie, Long> {

}
