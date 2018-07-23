package lec2final;

import lec2final.customer.Customer;
import lec2final.movie.Movie;
import lec2final.movie.MovieType;
import lec2final.rental.Rental;
import lec2final.report.HTMLReporter;
import lec2final.report.Reporter;
import lec2final.report.TxtReporter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Reporter reporter;
    private static BufferedReader reader;

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Die Hard", MovieType.REGULAR));        // 0
        movies.add(new Movie("Die Hard 2", MovieType.REGULAR));      // 1
        movies.add(new Movie("Die Hard 3", MovieType.REGULAR));      // 2
        movies.add(new Movie("Rusalochka", MovieType.CHILDRENS));    // 3
        movies.add(new Movie("Skyscraper", MovieType.NEW_RELEASE));   // 4
        movies.add(new Movie("Deadpool", MovieType.NEW_RELEASE));     // 5

        Customer customer1 = new Customer("Ivan");
        customer1.addRental(new Rental(movies.get(0), 3));
        customer1.addRental(new Rental(movies.get(1), 2));
        customer1.addRental(new Rental(movies.get(3), 5));
        customer1.addRental(new Rental(movies.get(5), 1));
        customer1.addRental(new Rental(movies.get(4), 10));

        while(reporter==null){
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("В каком формате вы хотите получить результат? Варианты: TXT, HTML");
            String answer = null;
            while (answer == null){
                try {
                    answer = reader.readLine();
                    if (!answer.equals("TXT")&&!answer.equals("HTML")){
                        System.out.println("Выберите один из двух вариантов: TXT, HTML");
                        answer = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (answer.equals("TXT")){
                reporter = new TxtReporter();
            }else {
                reporter = new HTMLReporter();
            }
        }
        System.out.println(reporter.processReport(customer1));

    }
}
