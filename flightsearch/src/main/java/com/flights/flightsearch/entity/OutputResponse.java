package com.flights.flightsearch.entity;

import java.util.List;

public class OutputResponse {
	
	private List<Flight> flights;
	private int total;
	
	public OutputResponse(List<Flight> flights, int total) {
		this.flights = flights;
		this.total = total;
	}
	
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
