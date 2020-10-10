package com.coding.movie.interfaces;


import com.coding.movie.dto.MovieDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author joshua.n.abellanosa
 * @since 10/9/2020
 */
public interface MovieOperation {


    /**
     *
     * @return all movies from DB
     */
    @GetMapping("/all")
    List<MovieDTO> getAllMovies();


    /**
     *
     * @param id search from based on this id
     * @return single movie with a specific id
     */
    @GetMapping("/{id}")
    Object getSpecificMovie(@PathVariable int id);

    /**
     *
     * @param page result is by 20 (i.e, page 2 means 21-40)
     * @return all movies from themoviedb API of specific page arranged by popularity
     */
    @GetMapping("/api/all/{page}")
    List<MovieDTO> getAllMoviesFromApi(@PathVariable int page);

    /**
     *
     * @param id criteria for searching based on id
     * @return single movie from themoviedb API with specific id
     */
    @GetMapping("api/{id}")
    Object getSpecificMovieFromApi(@PathVariable int id);
}
