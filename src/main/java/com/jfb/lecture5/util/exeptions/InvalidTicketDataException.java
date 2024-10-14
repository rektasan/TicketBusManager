package com.jfb.lecture5.util.exeptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class InvalidTicketDataException extends JsonProcessingException {

  public InvalidTicketDataException(String message, Throwable cause) {
    super(message, cause);
  }

}
