package com.dawit.moviecatalogservice.resources;


import com.dawit.moviecatalogservice.models.CatalogItem;
import com.dawit.moviecatalogservice.models.Movie;
import com.dawit.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    //injecting the defined bean singleton in this controller
    @Autowired()
    RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {


        //get the rating of all movies from ratingsdata service
        List<Rating> ratings = Arrays.asList(
                new Rating(1, 5),
                new Rating(2, 7)
        );

        //stream consists of useful methods
        //for each movie rated get the movie info
        //put the result from both the service and return rated movies
        return  ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:7072/movies/"+ rating.getId(), Movie.class);

            return  new CatalogItem(movie.getName(), "Sci-fi", rating.getRating());

        }).collect(Collectors.toList());




    }
}
