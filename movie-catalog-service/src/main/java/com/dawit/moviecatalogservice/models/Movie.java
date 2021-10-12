package com.dawit.moviecatalogservice.models;

public class Movie {

    int movieId;
    String name;

    //empty constructor for the rest template to Deserialize the incoming object
    public Movie(){
    }

    public Movie(int movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
