package com.revature.p1.service;

import com.revature.p1.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MovieService {

    private final RestTemplate restTemplate;

//    @Autowired
    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Returns a list of movies from P0 API
    public List<Movie> getMovieList (){
        ResponseEntity<List<Movie>> responseEntity = restTemplate.exchange(
                "http://localhost:8082/myMovies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Movie>>() {}
        );
        List<Movie> movies = responseEntity.getBody();
        return movies;
    }

    //Returns an array of movies from P0 API
    public Movie[] getMovieArray () {
        ResponseEntity<Movie[]> responseEntity = restTemplate.getForEntity("http://localhost:8082/myMovies", Movie[].class);
        Movie[] movieArray = responseEntity.getBody();
        return movieArray;
    }

}
