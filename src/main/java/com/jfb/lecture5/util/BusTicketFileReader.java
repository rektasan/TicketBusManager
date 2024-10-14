package com.jfb.lecture5.util;


import com.jfb.lecture5.model.BusTicket;
import com.jfb.lecture5.util.exeptions.InvalidTicketDataException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BusTicketFileReader {

  public static List<String> readBusTicketsFromFile(String filePath) throws IOException {
    return Files.readAllLines(Paths.get(filePath));
  }

  public static BusTicket mapBusTicketFromString(String ticketString) throws JsonProcessingException {
    try {
      return new ObjectMapper().readValue(ticketString.replace("“", "\"").replace("”", "\""), BusTicket.class);
    } catch (JsonProcessingException e) {
      throw new InvalidTicketDataException(Constants.INVALID_TICKET_DATA_ERROR_MESSAGE, e.getCause());
    }
  }

}
