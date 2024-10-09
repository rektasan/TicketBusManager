package com.jfb.lecture5;

import com.jfb.lecture5.model.BusTicket;
import com.jfb.lecture5.util.BusTicketFileReader;
import com.jfb.lecture5.util.BusTicketStats;
import com.jfb.lecture5.util.BusTicketValidator;
import com.jfb.lecture5.util.Constants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jfb.lecture5.util.exeptions.InvalidTicketDataException;

import java.io.IOException;
import javax.imageio.IIOException;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    try {
      List<String> ticketEntries = BusTicketFileReader.readBusTicketsFromFile(Constants.TICKET_FILEPATH);
      BusTicketStats ticketStats = new BusTicketStats();

      for (String ticketEntry : ticketEntries) {
        try {
          BusTicket busTicket = BusTicketFileReader.mapBusTicketFromString(ticketEntry);
          ticketStats.incrementTotalTickets();

          if (BusTicketValidator.validateBusTicket(busTicket, ticketStats)) {
            ticketStats.incrementTotalValidTickets();
          }
        } catch (JsonProcessingException e) {
          throw new InvalidTicketDataException(e.getMessage(), e.getCause());
        }
      }

      ticketStats.printBusTicketStats();
    } catch (IIOException e) {
      throw new IOException(e.getMessage());
    }
  }

}
