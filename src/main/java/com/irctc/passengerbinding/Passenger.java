package com.irctc.passengerbinding;

import lombok.Data;

@Data
public class Passenger {
  private Integer ticket_id;
  private String fname;
  private String lname;
  private String doj;
  private String from;
  private String to;
  private String trainNum;
}
