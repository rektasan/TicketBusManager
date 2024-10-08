package com.jfb.lecture5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.jfb.lecture5.model.BusTicket;
import com.jfb.lecture5.util.BusTicketValidator;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws JsonProcessingException {
    int totalTickets = 0;
    int totalValidTickets = 0;

    do {
      try {
        String input = getInput().replace("“", "\"").replace("”", "\"");
        BusTicket busTicket = new ObjectMapper().readValue(input, BusTicket.class);

        boolean isValid = BusTicketValidator.validateBusTicket(busTicket);

        if (isValid) {
          totalValidTickets++;
        }

        System.out.println(busTicket.toString());
      } catch (JsonProcessingException e) {
        System.err.println("Violation: Invalid input. Please, provide a valid JSON.");
      }

      totalTickets++;

    } while (totalTickets < 5);

    printMostPopularViolation(totalTickets, totalValidTickets);
  }

  private static String getInput() {
    System.out.println("Enter ticket info in JSON format: ");
    return new Scanner(System.in).nextLine();
  }

  private static void printMostPopularViolation(int totalTickets, int totalValidTickets) {
    String mostPopularViolation = BusTicketValidator.determineMostPopularViolation();
    System.out.println("Total = " + totalTickets +
        "\nValid = " + totalValidTickets +
        "\nMost popular violation = " + mostPopularViolation);
  }

}
