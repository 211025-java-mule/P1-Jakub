package com.revature.p1.controller;

import com.revature.p1.model.Movie;
import com.revature.p1.repository.MovieRepository;
import com.revature.p1.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MoviesController {

    private final MovieService movieService;
    private final MovieRepository movieRepository;

    public MoviesController(MovieService movieService, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }

    //downloads a list of movies, translate the plot of each of them to Polish, save it to DB, return list as JSON
    @GetMapping(value = "/list", produces = "application/json;charset=utf8")
    public List<Movie> getMovieList(){

        List<Movie> movieList = movieService.getMovieList();

//        movieService.translatePlot(movieList);

        movieRepository.saveAll(movieList);

        return movieList;
    }

}
