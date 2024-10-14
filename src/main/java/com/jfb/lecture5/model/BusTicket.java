package com.jfb.lecture5.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BusTicket {

  private String ticketClass;

  private String ticketType;

  private String startDate;

  private String price;

}
