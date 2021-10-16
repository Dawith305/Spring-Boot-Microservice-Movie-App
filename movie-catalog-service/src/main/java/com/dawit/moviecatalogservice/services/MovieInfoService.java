package com.dawit.moviecatalogservice.services;

import com.dawit.moviecatalogservice.models.CatalogItem;
import com.dawit.moviecatalogservice.models.Movie;
import com.dawit.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackMovieInfo")
    public CatalogItem getMovieInfo(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rating.getId(), Movie.class);
        return  new CatalogItem(movie.getName(), "Sci-fi", rating.getRating());
    }

    public CatalogItem getFallbackMovieInfo(Rating rating) {
        return new CatalogItem("No Movie","No Des",rating.getId());
    }
}
