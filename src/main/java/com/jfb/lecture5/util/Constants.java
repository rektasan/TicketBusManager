package com.jfb.lecture5.util;

import java.util.Arrays;
import java.util.List;

public class Constants {

  public static final String START_DATE_VIOLATION = "start date";
  public static final String PRICE_VIOLATION = "price";
  public static final String TICKET_TYPE_VIOLATION = "ticket type";

  public static final List<String> VALID_TICKET_TYPES = Arrays.asList("DAY", "WEEK", "MONTH", "YEAR");
  public static final List<String> START_DATE_REQUIRED_TYPES = Arrays.asList("DAY", "WEEK", "YEAR");

  public static final String INVALID_TICKET_DATA_ERROR_MESSAGE = "Invalid data. Please, make sure you have provided valid JSON data. ";

  public static final String TICKET_FILEPATH = "src\\main\\resources\\ticketData.txt";

}
