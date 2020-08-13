package com.flights.flightsearch.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="flight_number")
	private int flightNumber;
	
	@Column(name="airline_name")
	private String airlineName;
	
	@Column(name="source")
	private String sourceCity;
	
	@Column(name="destination")
	private String destinationCity;
	
	@Column(name="departure_time")
	private LocalDateTime departureTime;
	
	@Column(name="arrival_time")
	private LocalDateTime arrivalTime;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="no_of_stops")
	private int noOfStops;
	
	@Column(name="price")
	private int price;

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getNoOfStops() {
		return noOfStops;
	}

	public void setNoOfStops(int noOfStops) {
		this.noOfStops = noOfStops;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
