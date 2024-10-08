package com.jfb.lecture5.util;

import com.jfb.lecture5.model.BusTicket;
import lombok.Getter;

@Getter
public class BusTicketValidator {

  private static int startDateViolations;
  private static int priceViolations;

  public static boolean validateBusTicket(BusTicket busTicket) {
    boolean isValid = true;

    if (busTicket.getTicketType() != null &&
        (busTicket.getTicketType().equals("DAY") || busTicket.getTicketType().equals("WEEK") || busTicket.getTicketType().equals("YEAR"))) {

      if (busTicket.getStartDate() == null || busTicket.getStartDate().isEmpty()) {
        System.err.println("Violation: startDate is missing for : " + busTicket);
        startDateViolations++;
        isValid = false;
      }

    }

    try {
      double price = Double.parseDouble(busTicket.getPrice());

      if (price == 0) {
        System.err.println("Violation: price is zero for : " + busTicket);
        priceViolations++;
        isValid = false;
      }
    } catch (NumberFormatException e) {
      System.err.println("Violation: price is in invalid format for : " + busTicket);
      priceViolations++;
      isValid = false;
    } catch (NullPointerException e) {
      System.err.println("Violation: price can not be null for : " + busTicket);
      priceViolations++;
      isValid = false;
    }

    return isValid;
  }

  public static String determineMostPopularViolation() {
    if (startDateViolations > priceViolations) return "start date";
    else if (priceViolations > startDateViolations) return  "price";
    else return "none";
  }

}
