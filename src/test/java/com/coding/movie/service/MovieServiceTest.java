package com.coding.movie.service;

import com.coding.movie.entity.Movie;
import com.coding.movie.exception.NoSuchMovieException;
import com.coding.movie.repository.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieService service;

    @Mock
    private MovieRepository repo;

    @Mock
    private Movie movie;

    @Test
    public void testGetAllMovies(){
        List<Movie> dbMovieList = new ArrayList<>();
        dbMovieList.add(movie);

        Mockito.when(repo.findAll()).thenReturn(dbMovieList);

        assertEquals(1, service.getAllMovies().size());
    }

    @Test
    public void testGetAllMoviesThrowsException(){
        List<Movie> dbMovieList = new ArrayList<>();
        dbMovieList.add(null);

        Mockito.when(repo.findAll()).thenReturn(dbMovieList);

        assertEquals(0, service.getAllMovies().size());
    }

    @Test
    public void testGetMovieById() throws Exception{
        Mockito.when(movie.getMovieTitle()).thenReturn("abc");
        Mockito.when(repo.findByMovieId(Mockito.anyInt())).thenReturn(movie);

        assertEquals("abc", service.getMovieById(1).getMovieTitle());
    }

    @Test
    public void testGetAllMoviesFromApi(){
        assertEquals(20, service.getAllMoviesFromApi(1).size());
    }

    @Test(expected = NoSuchMovieException.class)
    public void testGetMoviesFromApiByIdThrowsException() throws Exception{
        assertEquals("abc", service.getMoviesFromApiById(1).getMovieTitle());
    }

    @Test
    public void testGetMoviesFromApiById() throws Exception{
        assertEquals("Absolut", service.getMoviesFromApiById(555).getMovieTitle());
    }
}
