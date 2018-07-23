package lec2final.customer;

import lec2final.rental.Rental;

import java.util.ArrayList;
import java.util.List;


public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public List<Rental> get_rentals() {
        return _rentals;
    }

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : _rentals) {
            frequentRenterPoints += rental.rentalPoints();
        }
        return frequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : _rentals) {
            totalAmount += rental.rentalCost();
        }
        return totalAmount;
    }

}
