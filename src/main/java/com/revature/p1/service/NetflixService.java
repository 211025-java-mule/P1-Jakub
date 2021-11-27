package com.revature.p1.service;

import com.revature.p1.model.Movie;
import com.revature.p1.model.Source;
import com.revature.p1.model.WatchModeResult;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class NetflixService {

    private final RestTemplate restTemplate;
    private static final String WatchMode_KEY = System.getenv("WatchMode_key");

    public NetflixService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Checks each movie on a given list if it is available on Netflix,
    //if so, it changes the value of the Netflix field to true. Returns the list with the changed list
    public List<Movie> checkNetflixAvailability(List<Movie> movieList) {
        for (Movie movie : movieList) {
            WatchModeResult watchModeResult = getTitleInfo(movie.getId());
            String watchModeID = watchModeResult.getTitle_results().get(0).getId();
            List<Source> sourceList = getSources(watchModeID);
            for (Source source : sourceList){
                if (source.getSource_id().equals("203")){
                    movie.setNetflix(true);
                }
            }
        }
        return movieList;
    }

    //Returns title information based on the given IMDb id, uses the WatchMode API.
    public WatchModeResult getTitleInfo(String imdb_id){
        ResponseEntity<WatchModeResult> responseEntity = restTemplate.exchange(
                "https://api.watchmode.com/v1/search/?apiKey=" + WatchMode_KEY + "&search_field=imdb_id&search_value=" + imdb_id,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                WatchModeResult.class
        );
        return responseEntity.getBody();
    }

    //Returns list of sources based on the given WatchMode id, uses the WatchMode API.
    public List<Source> getSources(String watchMode_id) {
        ResponseEntity<List<Source>> responseEntity = restTemplate.exchange(
                "https://api.watchmode.com/v1/title/" + watchMode_id + "/sources/?apiKey=" + WatchMode_KEY,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Source>>() {}
        );
        return responseEntity.getBody();
    }
}
