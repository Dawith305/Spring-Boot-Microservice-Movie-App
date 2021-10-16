package com.dawit.moviecatalogservice.services;

import com.dawit.moviecatalogservice.models.Rating;
import com.dawit.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfoService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackRatingsData")
    public UserRating getRatingsData(String userId) {
        return restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+ userId, UserRating.class);
    }

    public UserRating getFallbackRatingsData(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserRating(Arrays.asList( new Rating(0,0)));
        return  userRating;
    }
}
