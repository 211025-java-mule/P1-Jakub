package com.revature.p1.controller;

import com.revature.p1.model.Movie;
import com.revature.p1.repository.MovieRepository;
import com.revature.p1.service.MovieService;
import com.revature.p1.service.NetflixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MoviesController {

    private final MovieService movieService;
    private final MovieRepository movieRepository;
    private final NetflixService netflixService;

    public MoviesController(MovieService movieService, MovieRepository movieRepository, NetflixService netflixService) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
        this.netflixService = netflixService;
    }

    //Downloads a list of movies, checks if the movie is available on Netflix,
    // translate the plot of each of them to Polish, save it to DB, return list as JSON.
    @GetMapping(value = "/list", produces = "application/json;charset=utf8")
    public List<Movie> getMovieList(){

        List<Movie> movieList = movieService.getMovieList();

        netflixService.checkNetflixAvailability(movieList);

        movieService.translatePlot(movieList);

        movieRepository.saveAll(movieList);

        return movieList;
    }

}
