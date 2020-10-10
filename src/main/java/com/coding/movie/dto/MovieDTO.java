package com.coding.movie.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO implements Serializable {

    private static final long serialVersionUID = 4258145108416018061L;

    @JsonProperty("Movie Title")
    private String movieTitle;

    @JsonProperty("Movie Overview")
    private String movieOverview;

    @JsonProperty("Movie Poster")
    private String moviePoster;

    @JsonProperty("Movie Vote Average")
    private String movieVoteAvg;

    @JsonProperty("Movie Release Date")
    private Date movieRelDate;

    @JsonIgnore
    private float moviePopularity;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieVoteAvg() {
        return movieVoteAvg;
    }

    public void setMovieVoteAvg(String movieVoteAvg) {
        this.movieVoteAvg = movieVoteAvg;
    }

    public Date getMovieRelDate() {
        return movieRelDate;
    }

    public void setMovieRelDate(Date movieRelDate) {
        this.movieRelDate = movieRelDate;
    }

    public Float getMoviePopularity() {
        return moviePopularity;
    }

    public void setMoviePopularity(Float moviePopularity) {
        this.moviePopularity = moviePopularity;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieTitle='" + movieTitle + '\'' +
                ", movieOverview='" + movieOverview + '\'' +
                ", moviePoster='" + moviePoster + '\'' +
                ", movieVoteAvg='" + movieVoteAvg + '\'' +
                ", movieRelDate=" + movieRelDate +
                ", moviePopularity=" + moviePopularity +
                '}';
    }
}
