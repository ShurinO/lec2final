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

        String result = "Учет аренды для " + getName() + "\n";

        for (Rental rental : _rentals) {
//показать результаты для этой аренды
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.rentalCost()) + "\n";
        }

        double totalAmount = 0;
        for (Rental rental : _rentals) {
            totalAmount += rental.rentalCost();
        }

        int frequentRenterPoints = 0;
        for (Rental rental : _rentals) {
            frequentRenterPoints += rental.rentalPoints();
        }
//добавить нижний колонтитул
        result += "Сумма задолженности составляет " +
                String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) + " очков за активность";
        return result;
    }

}
