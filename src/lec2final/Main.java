package lec2final;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Die Hard", Movie.REGULAR));        // 0
        movies.add(new Movie("Die Hard 2", Movie.REGULAR));      // 1
        movies.add(new Movie("Die Hard 3", Movie.REGULAR));      // 2
        movies.add(new Movie("Rusalochka", Movie.CHILDRENS));    // 3
        movies.add(new Movie("Skyscraper", Movie.NEW_RELEASE));  // 4
        movies.add(new Movie("Deadpool", Movie.NEW_RELEASE));    // 5

        Customer customer1 = new Customer("Ivan");
        customer1.addRental(new Rental(movies.get(0), 3));
        customer1.addRental(new Rental(movies.get(1), 2));
        customer1.addRental(new Rental(movies.get(3), 5));
        customer1.addRental(new Rental(movies.get(5), 1));
        customer1.addRental(new Rental(movies.get(4), 10));

        System.out.println(customer1.statement());
    }
}
