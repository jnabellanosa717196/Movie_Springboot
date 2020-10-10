package com.coding.movie.service;

import com.coding.movie.comparator.MovieComparator;
import com.coding.movie.dto.MovieDTO;
import com.coding.movie.entity.Movie;
import com.coding.movie.exception.NoSuchMovieException;
import com.coding.movie.repository.MovieRepository;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.core.ResponseStatusException;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author joshua.n.abellanosa
 * @since 10/9/2020
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    /**
     *
     * @return all movies from DB
     */
    public List<MovieDTO> getAllMovies(){
        List<Movie> dbMovieList;
        List<MovieDTO> dtoMovieList = new ArrayList<>();

        dbMovieList = movieRepo.findAll();

        dbMovieList.forEach(e -> {
            try {
                dtoMovieList.add(mapToDto(e));
            } catch (NoSuchMovieException ex) {
                System.out.println(ex.getMessage());
            }
        });

        return dtoMovieList;
    }

    /**
     *
     * @param movie to map DTO
     * @return MovieDTO object that is mapped from DB row
     * @throws NoSuchMovieException when movie with specific id not found
     */
    private MovieDTO mapToDto(Movie movie) throws NoSuchMovieException {
        MovieDTO movieDTO = new MovieDTO();

        if(ObjectUtils.isEmpty(movie)){
            throw new NoSuchMovieException("No movie found for this specific id : ");
        }

        movieDTO.setMovieTitle(movie.getMovieTitle());
        movieDTO.setMovieOverview(movie.getMovieOverview());
        movieDTO.setMoviePoster(movie.getMoviePoster());
        movieDTO.setMovieVoteAvg(String.valueOf(movie.getMovieVoteAvg()));
        movieDTO.setMovieRelDate(movie.getMovieRelDate());

        return movieDTO;
    }

    /**
     *
     * @param id criteria to search in DB
     * @return movie with specific id in DB
     * @throws NoSuchMovieException when movie with specific id not found
     */
    public MovieDTO getMovieById(int id) throws NoSuchMovieException {
        Movie movie = movieRepo.findByMovieId(id);

        return mapToDto(movie);
    }


    /**
     *
     * @param page specific page of all movies
     * @return all movies in specific page order by popularity descending
     */
    public List<MovieDTO> getAllMoviesFromApi(int page){
        TmdbMovies tmdbMovies = new TmdbApi("f6277e90ee9567d1975ea7c32f8fb401").getMovies();
        List<MovieDTO> dtoMovieList = new ArrayList<>();

        MovieResultsPage movieResultsPage = tmdbMovies.getPopularMovies("en", page);

        movieResultsPage.forEach(e -> dtoMovieList.add(mapToDto(e)));
        dtoMovieList.sort(new MovieComparator());

        return dtoMovieList;
    }

    /**
     *
     * @param id specific movie to find
     * @return movie with specific id
     * @throws NoSuchMovieException when no movie with specific id
     */
    public MovieDTO getMoviesFromApiById(int id) throws NoSuchMovieException {
        TmdbMovies tmdbMovies = new TmdbApi("f6277e90ee9567d1975ea7c32f8fb401").getMovies();
        try{
            MovieDb movieDb = tmdbMovies.getMovie(id,"en");
            return mapToDto(movieDb);
        }catch (ResponseStatusException ex){
            throw new NoSuchMovieException("No movie found for this specific id :");
        }

    }
    /**
     *
     * @param movie to map DTO
     * @return MovieDTO object that is mapped from themoviedb API
     */
    private MovieDTO mapToDto(MovieDb movie){
        MovieDTO movieDTO = new MovieDTO();

        try{
            movieDTO.setMovieTitle(movie.getTitle());
            movieDTO.setMovieOverview(movie.getOverview());
            movieDTO.setMoviePoster(movie.getPosterPath());
            movieDTO.setMovieVoteAvg(String.valueOf(movie.getVoteAverage()));
            movieDTO.setMovieRelDate(new SimpleDateFormat("yyyy-MM-dd").parse(movie.getReleaseDate()));
            movieDTO.setMoviePopularity(movie.getPopularity());
        }catch (ParseException ex){
            movieDTO.setMovieRelDate(null);
        }

        return movieDTO;
    }
}
