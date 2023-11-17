package com.irctc.passengerbinding;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Ticket {
  private Integer ticket_id;
  private String from;
  private String to;
  private String ticketStatus;
  private String tktCost;
  private String trainNum;
}
