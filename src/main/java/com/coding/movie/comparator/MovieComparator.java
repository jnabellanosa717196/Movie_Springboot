package com.coding.movie.comparator;

import com.coding.movie.dto.MovieDTO;

import java.util.Comparator;

public class MovieComparator implements Comparator<MovieDTO> {

    /**
     * Used to sort list based on popularity in descending order
     *
     * @param o1 MovieDTO
     * @param o2 MovieDTO
     * @return movie with bigger popularity
     */

    @Override
    public int compare(MovieDTO o1, MovieDTO o2) {
        return o2.getMoviePopularity().compareTo(o1.getMoviePopularity());
    }
}
