package com.flights.flightsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flights.flightsearch.dao.FlightsDAO;
import com.flights.flightsearch.entity.Flight;

@Service
public class FlightsService {
	
	private FlightsDAO flightsDAO;

	@Autowired
	public FlightsService(FlightsDAO flightsDAO) {
		this.flightsDAO = flightsDAO;
	}
	
	@Transactional
	public List<Flight> searchFlights(String sourceCity, String destinationCity, String travelDate, String returnDate){
		return flightsDAO.searchFlights(sourceCity,destinationCity,travelDate,returnDate);
	}
	
	
}
