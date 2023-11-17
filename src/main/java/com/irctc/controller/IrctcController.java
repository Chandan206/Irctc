package com.irctc.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.irctc.passengerbinding.Passenger;
import com.irctc.passengerbinding.Ticket;

@RestController
public class IrctcController {
	private Map<Integer, Ticket> tickets=new HashMap<>();
@PostMapping(value="/ticket" ,consumes= {"application/xml","application/json"},produces = {"application/xml","application/json"})
	public Ticket bookTicket(@RequestBody Passenger p){
		Ticket t=new Ticket();
		Random r=new Random();
		int ticket_id=r.nextInt();
		t.setTicket_id(ticket_id);
		t.setFrom(p.getFrom());
		t.setTo(p.getTo());
		t.setTicketStatus("Conformed");
		t.setTktCost("1500");
		t.setTrainNum(p.getTrainNum());
		tickets.put(ticket_id, t);
		return t;
		
	}
@GetMapping(value="/ticket/{ticket_id}",produces = {"application/xml","application/json"})
public Ticket getTicket(@PathVariable Integer ticket_id) {
	  if(tickets.containsKey(ticket_id)) {
		  return tickets.get(ticket_id);
	  }
	return null;
  }
}
