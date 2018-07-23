package lec2final.report;

import lec2final.customer.Customer;
import lec2final.rental.Rental;

public class HTMLReporter implements Reporter {
    @Override
    public String processReport(Customer customer) {
        StringBuilder result = new StringBuilder("<html lang=\"ru\"><meta charset=\"utf-8\"><body>" +
                "<table><tr><th style=\"text-align: left;\" colspan=\"3\">Учет аренды для " + customer.getName() + "</th>");

        for (Rental rental : customer.get_rentals()) {
            //показать результаты для этой аренды
            result.append("<tr><td>\t</td><td>").append(rental.getMovie().getTitle()).append("</td><td>").append(rental.rentalCost()).append("</td></tr>");
        }

        //добавить нижний колонтитул
        result.append("<tr><td colspan=\"2\">Сумма задолженности составляет\t</td><td>").append(customer.getTotalAmount()).append("</td></tr>");
        result.append("<tr><td colspan=\"3\">Вы заработали ").append(customer.getFrequentRenterPoints()).append(" очков за активность</td></tr>");
        result.append("</table></body></html>");
        return result.toString();
    }
}
