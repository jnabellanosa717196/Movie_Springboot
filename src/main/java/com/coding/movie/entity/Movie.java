package com.coding.movie.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MOVIE", schema = "dbo")
public class Movie {

    @Id
    @Column(name = "MOVIE_ID")
    private Integer movieId;

    @Column(name = "MOVIE_TITLE", length = 50, nullable = true, unique = false)
    private String movieTitle;

    @Column(name = "MOVIE_OVERVIEW", length = 500, nullable = true, unique = false)
    private String movieOverview;

    @Column(name = "MOVIE_POSTER", length = 100, nullable = true, unique = false)
    private String moviePoster;

    @Column(name = "MOVIE_VOTE_AVG", length = 50, nullable = true, unique = false)
    private Integer movieVoteAvg;

    @Temporal(TemporalType.DATE)
    @Column(name = "MOVIE_REL_DATE", nullable = true, unique = false)
    private Date movieRelDate;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

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

    public Integer getMovieVoteAvg() {
        return movieVoteAvg;
    }

    public void setMovieVoteAvg(Integer movieVoteAvg) {
        this.movieVoteAvg = movieVoteAvg;
    }

    public Date getMovieRelDate() {
        return movieRelDate;
    }

    public void setMovieRelDate(Date movieRelDate) {
        this.movieRelDate = movieRelDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieOverview='" + movieOverview + '\'' +
                ", moviePoster='" + moviePoster + '\'' +
                ", movieVoteAvg=" + movieVoteAvg +
                ", movieRelDate=" + movieRelDate +
                '}';
    }
}
