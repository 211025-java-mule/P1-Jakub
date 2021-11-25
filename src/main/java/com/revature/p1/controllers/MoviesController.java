package com.revature.p1.controllers;

import com.revature.p1.service.MovieService;
import com.revature.p1.service.TranslatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MoviesController {

    private final MovieService movieService;
    private final TranslatorService translatorService;

    public MoviesController(MovieService movieService, TranslatorService translatorService) {
        this.movieService = movieService;
        this.translatorService = translatorService;
    }

    @GetMapping(value = "/movieList", produces = "application/json;charset=utf8")
    public String getMovieList(){
//        return translatorService.getTranslation(movieService.getMovieList().get(1).plot).getText();
//        return translatorService.getTranslation(movieService.getMovieList().get(1).plot).toString();
//        return translatorService.getTranslationString(movieService.getMovieList().get(1).plot);
        return translatorService.getTranslation(movieService.getMovieList().get(1).plot).getTranslations().get(0).getText();
//        return movieService.getMovieList().get(1).plot;
    }

    @GetMapping("/movieArray")
    public String movieArray (){
        return movieService.getMovieArray()[1].plot;
    }

}
