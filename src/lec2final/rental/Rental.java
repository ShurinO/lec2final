package lec2final.rental;

import lec2final.movie.Movie;

public class Rental {
    private Movie _movie;
    private int _daysRented;
    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }
    public int getDaysRented() {
        return _daysRented;
    }
    public Movie getMovie() {
        return _movie;
    }

    public int rentalPoints() {
        return getMovie().rentalPoints(getDaysRented());
    }

    public double rentalCost() {
        return getMovie().rentalCost(getDaysRented());
    }
}
