package com.work.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.work.demo.entity.FlightDetails;

@Service
public interface FlightDetailsService {
	
	public List<FlightDetails> getFlightSearchDetails( String sourceCity, String destinationCity, LocalDate travelDate, LocalDate returnDate);
	
	public List<FlightDetails> getAllFlightDetails();
	
	public List<FlightDetails> getOrderByDepartureTimeAsc();
	
	public List<FlightDetails> getOrderByDepartureTimeDesc();
	
	public List<FlightDetails> getOrderByDurationAsc();
	
	public List<FlightDetails> getOrderByDurationDesc();
	
	public List<FlightDetails> getOrderByAirlineNameAsc();
	
	public List<FlightDetails> getOrderByAirlineNameDesc();

	public List<FlightDetails> getOrderByPriceDesc();
	
}
