package lec2final.report;

import lec2final.customer.Customer;
import lec2final.rental.Rental;

public class TxtReporter implements Reporter {
    @Override
    public String processReport(Customer customer) {
        StringBuilder result = new StringBuilder("Учет аренды для " + customer.getName() + "\n");

        for (Rental rental : customer.get_rentals()) {
            //показать результаты для этой аренды
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(String.valueOf(rental.rentalCost())).append("\n");
        }

        //добавить нижний колонтитул
        result.append("Сумма задолженности составляет ").append(String.valueOf(customer.getTotalAmount())).append("\n");
        result.append("Вы заработали ").append(String.valueOf(customer.getFrequentRenterPoints())).append(" очков за активность");
        return result.toString();
    }
}
