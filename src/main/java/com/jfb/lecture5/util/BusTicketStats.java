package com.jfb.lecture5.util;

public class BusTicketStats {

  private int totalTickets;
  private int totalValidTickets;

  private int startDateViolations;
  private int priceViolations;
  private int ticketTypeViolations;

  public BusTicketStats() {
    this.totalTickets = 0;
    this.totalValidTickets = 0;
    this.startDateViolations = 0;
    this.priceViolations = 0;
    this.ticketTypeViolations = 0;
  }


  public void incrementTotalTickets() {
    totalTickets++;
  }

  public void incrementTotalValidTickets() {
    totalValidTickets++;
  }

  public void incrementStartDateViolations() {
    startDateViolations++;
  }

  public void incrementPriceViolations() {
    priceViolations++;
  }

  public void incrementTicketTypeViolations() {
    ticketTypeViolations++;
  }


  public void printBusTicketStats() {
    String mostPopularViolation = determineMostPopularViolation();
    System.out.println(
        "Total = " + totalTickets +
            "\nValid = " + totalValidTickets +
            "\nMost popular violation = " + mostPopularViolation
    );
  }

  private String determineMostPopularViolation() {
    if (startDateViolations > priceViolations && startDateViolations > ticketTypeViolations) {
      return Constants.START_DATE_VIOLATION + ": " + startDateViolations;
    }
    if (priceViolations > startDateViolations && priceViolations > ticketTypeViolations) {
      return Constants.PRICE_VIOLATION + ": " + priceViolations;
    } else {
      return Constants.TICKET_TYPE_VIOLATION + ": " + ticketTypeViolations;
    }
  }

}
