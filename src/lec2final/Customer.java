package lec2final;

import java.util.ArrayList;
import java.util.List;


public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {

        StringBuilder result = new StringBuilder("Учет аренды для " + getName() + "\n");

        for (Rental rental : _rentals) {
//показать результаты для этой аренды
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(String.valueOf(rental.rentalCost())).append("\n");
        }

//добавить нижний колонтитул
        result.append("Сумма задолженности составляет ").append(String.valueOf(getTotalAmount())).append("\n");
        result.append("Вы заработали ").append(String.valueOf(getFrequentRenterPoints())).append(" очков за активность");
        return result.toString();
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : _rentals) {
            frequentRenterPoints += rental.rentalPoints();
        }
        return frequentRenterPoints;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : _rentals) {
            totalAmount += rental.rentalCost();
        }
        return totalAmount;
    }

}
