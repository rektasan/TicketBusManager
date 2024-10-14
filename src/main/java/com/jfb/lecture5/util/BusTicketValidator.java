package com.jfb.lecture5.util;

import com.jfb.lecture5.model.BusTicket;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BusTicketValidator {

  public static boolean validateBusTicket(BusTicket busTicket, BusTicketStats ticketStats) {
    boolean isValid = true;

    if (!isValidBusTicketType(busTicket)) {
      ticketStats.incrementTicketTypeViolations();
      isValid = false;
      System.err.println("Invalid ticket type for: " + busTicket);
    }

    if (isStartDateRequired(busTicket) && !isValidStartDate(busTicket)) {
      ticketStats.incrementStartDateViolations();
      isValid = false;
      System.err.println("Invalid start date for: " + busTicket);
    }

    if (!isValidPrice(busTicket)) {
      ticketStats.incrementPriceViolations();
      isValid = false;
      System.err.println("Invalid price for: " + busTicket);
    }

    return isValid;
  }

  private static boolean isValidBusTicketType(BusTicket busTicket) {
    return Constants.VALID_TICKET_TYPES.contains(busTicket.getTicketType());
  }

  private static boolean isStartDateRequired(BusTicket busTicket) {
    return Constants.START_DATE_REQUIRED_TYPES.contains(busTicket.getTicketType());
  }

  private static boolean isValidStartDate(BusTicket busTicket) {

    if (busTicket.getStartDate() == null || busTicket.getStartDate().trim().isEmpty()) {
      return false;
    }

    try {
      LocalDate startDate = LocalDate.parse(busTicket.getStartDate());
      return !startDate.isAfter(LocalDate.now());
    } catch (DateTimeParseException e) {
      return false;
    }
  }

  private static boolean isValidPrice(BusTicket busTicket) {
    try {
      int price = Integer.parseInt(busTicket.getPrice());
      return price > 0 && price % 2 == 0;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}
