package com.dawit.movieinfoservice.models;

public class Movie {

    int movieId;
    String name;
    String dec;

    //empty constructor for the rest template to Deserialize the incoming object
    public Movie(){
    }

    public Movie(int movieId, String name,String dec) {
        this.movieId = movieId;
        this.name = name;
        this.dec = dec;
    }
    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
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
