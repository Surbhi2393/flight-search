package com.flights.flightsearch.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flights.flightsearch.entity.Flight;

@Repository
public class FlightsDAO {

	private EntityManager entityManager;

	@Autowired
	public FlightsDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Flight> searchFlights(String sourceCity, String destinationCity, String travelDate, String returnDate) {

		Session session = entityManager.unwrap(Session.class);
		List<Flight> flights = new ArrayList<Flight>();

		LocalDateTime dateOfTravel = LocalDateTime.parse(travelDate);

		List<Flight> oneWayFlights = getForwardFlights(session, sourceCity, destinationCity, dateOfTravel);
		flights.addAll(oneWayFlights);

		if (!returnDate.isEmpty()) {
			LocalDateTime dateOfReturn = LocalDateTime.parse(returnDate);
			List<Flight> returnFlights = getReturnFlights(session, sourceCity, destinationCity, dateOfReturn);
			flights.addAll(returnFlights);
		}

		Collections.sort(flights, new Comparator<Flight>() {
			@Override
			public int compare(Flight o1, Flight o2) {
				return (o1.getFlightNumber()>o2.getFlightNumber()) ? 1: -1;
			}
		});
		return flights;
	}

	private List<Flight> getForwardFlights(Session session, String sourceCity, String destinationCity, LocalDateTime travelDate) {
		Query query = session.createQuery(
				"from Flight where sourceCity=:source and destinationCity=:destination and departureTime>:traveldate");
		query.setParameter("source", sourceCity);
		query.setParameter("destination", destinationCity);
		query.setParameter("traveldate", travelDate);
		return query.getResultList();
	}

	private List<Flight> getReturnFlights(Session session, String sourceCity, String destinationCity, LocalDateTime returnDate) {
		Query query1 = session.createQuery(
				"from Flight where sourceCity=:source and destinationCity=:destination and departureTime>:traveldate");
		query1.setParameter("source", destinationCity);
		query1.setParameter("destination", sourceCity);
		query1.setParameter("traveldate", returnDate);
		return query1.getResultList();
	}

}
