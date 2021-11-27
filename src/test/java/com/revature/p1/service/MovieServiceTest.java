package com.revature.p1.service;

import com.revature.p1.model.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceTest {

    MovieService movieService;
    TranslatorService translatorService;

    @Before
    public void setup() {
        org.springframework.web.client.RestTemplate restTemplate = new RestTemplate();
        translatorService = new TranslatorService(restTemplate);
        movieService = new MovieService(restTemplate, translatorService);
    }

    @Test
    public void testGetMovieList() {
        Assert.assertNotNull(movieService.getMovieList());
        Assert.assertEquals("tt", movieService.getMovieList().get(0).id.substring(0,2));
    }

    @Test
    public void testTranslatePlot() {
        Movie movie1 = new Movie();
        movie1.setPlot("Hello");
        Movie movie2 = new Movie();
        movie2.setPlot("Yes");
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);
        Assert.assertEquals("Witam", movieService.translatePlot(movieList).get(0).plot);
        Assert.assertEquals("Tak", movieService.translatePlot(movieList).get(1).plot);
    }
}