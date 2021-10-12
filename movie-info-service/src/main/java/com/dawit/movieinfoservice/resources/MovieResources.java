package com.dawit.movieinfoservice.resources;

import com.dawit.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movies")
public class MovieResources {

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") int movieId){
        return new Movie(movieId,"New Movie");
    }
}
