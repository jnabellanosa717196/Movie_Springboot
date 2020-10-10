package com.coding.movie.controller;


import com.coding.movie.dto.Error;
import com.coding.movie.dto.MovieDTO;
import com.coding.movie.exception.NoSuchMovieException;
import com.coding.movie.service.MovieService;
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
public class MovieControllerTest {

    @InjectMocks
    private MovieController controller;

    @Mock
    private MovieService service;

    @Mock
    private MovieDTO movieDTO;

    @Test
    public void testGetAllMovies(){
        List<MovieDTO> movieDTOList = new ArrayList<>();
        movieDTOList.add(movieDTO);

        Mockito.when(service.getAllMovies()).thenReturn(movieDTOList);

        assertEquals(1, controller.getAllMovies().size());
    }

    @Test
    public void testGetSpecificMovieSuccessful() throws Exception{
        Mockito.when(movieDTO.getMovieTitle()).thenReturn("abc");
        Mockito.when(service.getMovieById(Mockito.anyInt())).thenReturn(movieDTO);

        assertEquals("abc", ((MovieDTO)controller.getSpecificMovie(1)).getMovieTitle());
    }

    @Test
    public void testGetSpecificMovieThrowsException() throws Exception{
        Mockito.when(movieDTO.getMovieTitle()).thenReturn("abc");
        Mockito.when(service.getMovieById(Mockito.anyInt())).thenThrow(NoSuchMovieException.class);

        assertEquals(400, ((Error)controller.getSpecificMovie(1)).getErrorCode());
    }

    @Test
    public void testGetAllMoviesFromApi(){
        List<MovieDTO> movieDTOList = new ArrayList<>();
        movieDTOList.add(movieDTO);

        Mockito.when(service.getAllMoviesFromApi(Mockito.anyInt())).thenReturn(movieDTOList);

        assertEquals(1, controller.getAllMoviesFromApi(1).size());
    }

    @Test
    public void testGetSpecificMovieFromApiSuccessful() throws Exception{
        Mockito.when(movieDTO.getMovieTitle()).thenReturn("abc");
        Mockito.when(service.getMoviesFromApiById(Mockito.anyInt())).thenReturn(movieDTO);

        assertEquals("abc", ((MovieDTO)controller.getSpecificMovieFromApi(1)).getMovieTitle());
    }

    @Test
    public void testGetSpecificMovieFromApiThrowsException() throws Exception{
        Mockito.when(movieDTO.getMovieTitle()).thenReturn("abc");
        Mockito.when(service.getMoviesFromApiById(Mockito.anyInt())).thenThrow(NoSuchMovieException.class);

        assertEquals(400, ((Error)controller.getSpecificMovieFromApi(1)).getErrorCode());
    }
}
