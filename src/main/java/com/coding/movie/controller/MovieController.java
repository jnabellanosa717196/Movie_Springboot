package com.coding.movie.controller;

import com.coding.movie.dto.Error;
import com.coding.movie.dto.MovieDTO;
import com.coding.movie.exception.NoSuchMovieException;
import com.coding.movie.interfaces.MovieOperation;
import com.coding.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author joshua.n.abellanosa
 * @since 10/9/2020
 */

@RestController
@RequestMapping("/movies")
public class MovieController implements MovieOperation {

    @Autowired
    private MovieService movieService;

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @Override
    public Object getSpecificMovie(int id)  {
        try {
            return movieService.getMovieById(id);
        } catch (NoSuchMovieException e) {
            Error error = new Error();
            error.setErrorCode(HttpStatus.BAD_REQUEST.value());
            error.setErrorStatus(HttpStatus.BAD_REQUEST);
            error.setErrorMsg(e.getMessage()+id);
            return error;
        }
    }

    @Override
    public List<MovieDTO> getAllMoviesFromApi(int page) {
        return movieService.getAllMoviesFromApi(page);
    }

    @Override
    public Object getSpecificMovieFromApi(int id) {
        try {
            return movieService.getMoviesFromApiById(id);
        } catch (NoSuchMovieException e) {
            Error error = new Error();
            error.setErrorCode(HttpStatus.BAD_REQUEST.value());
            error.setErrorStatus(HttpStatus.BAD_REQUEST);
            error.setErrorMsg(e.getMessage()+id);
            return error;
        }
    }

}
