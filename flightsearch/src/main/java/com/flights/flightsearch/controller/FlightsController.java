package com.flights.flightsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flights.flightsearch.entity.Flight;
import com.flights.flightsearch.entity.OutputResponse;
import com.flights.flightsearch.service.FlightsService;

@RestController
public class FlightsController {
	
	private FlightsService flightsService;

	@Autowired
	public FlightsController(FlightsService flightsService) {
		this.flightsService = flightsService;
	}
	
	@GetMapping("/searchFlights")
	public OutputResponse searchFlights(@RequestParam(name="source", required = true) String sourceCity,
			@RequestParam(name="destination", required = true) String destinationCity,
			@RequestParam(name="travelDate", required = true) String travelDate,
			@RequestParam(name="returnDate", required = false, defaultValue = "") String returnDate){
		List<Flight> flights = flightsService.searchFlights(sourceCity, destinationCity, travelDate, returnDate);
		OutputResponse response = new OutputResponse(flights, flights.size());
		return response;
	}
	
	

}
