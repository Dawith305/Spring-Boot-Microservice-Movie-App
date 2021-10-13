package com.dawit.ratingdataservice.resource;

import com.dawit.ratingdataservice.models.Rating;
import com.dawit.ratingdataservice.models.UserRating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") int movieId){
        return new Rating(movieId,6);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") int userId){
        List<Rating> ratings  = Arrays.asList(
                        new Rating(1, 5),
                        new Rating(2, 7)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }
}
