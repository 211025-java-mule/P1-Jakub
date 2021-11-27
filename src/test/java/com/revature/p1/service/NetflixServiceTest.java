package com.revature.p1.service;

import com.revature.p1.model.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class NetflixServiceTest {

    NetflixService netflixService;

    @Before
    public void setup() {
        org.springframework.web.client.RestTemplate restTemplate = new RestTemplate();
        netflixService = new NetflixService(restTemplate);
    }

    @Test
    public void testCheckNetflixAvailability() {
        Movie movie = new Movie();
        movie.setId("tt0133093");
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
        Assert.assertTrue(netflixService.checkNetflixAvailability(movieList).get(0).netflix);
    }

    @Test
    public void testGetTitleInfo() {
        Assert.assertEquals("The Matrix", netflixService.getTitleInfo("tt0133093").getTitle_results().get(0).getName());
    }

    @Test
    public void testGetSources() {
        Assert.assertNotNull(netflixService.getSources("1406847"));
    }
}