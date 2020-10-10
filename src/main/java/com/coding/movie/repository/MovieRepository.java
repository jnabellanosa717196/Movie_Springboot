package com.coding.movie.repository;

import com.coding.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    /**
     *
     * @param id used to query movie in DB by id
     * @return movie with a specific id
     */
    Movie findByMovieId(int id);

    /**
     *
     * @return all movies in DB
     */
    List<Movie> findAll();
}
