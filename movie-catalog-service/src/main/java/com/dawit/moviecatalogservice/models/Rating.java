package com.dawit.moviecatalogservice.models;

public class Rating {

    int id;
    int rating;

    public Rating(){}
    public Rating(int id, int rating){
        this.id = id;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
