package com.work.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.demo.entity.FlightDetails;
import com.work.demo.repository.FlightDetailsRepository;
import com.work.demo.service.FlightDetailsService;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService{
	
	@Autowired
	FlightDetailsRepository fligthDetailsRepository;
	
	@Override
	public List<FlightDetails> getFlightSearchDetails(String sourceCity, String destinationCity, LocalDate travelDate,
			LocalDate returnDate) {
		return fligthDetailsRepository.findBySourceCityAndDestinationCityAndTravelDateAndReturnDate(sourceCity, destinationCity, travelDate, returnDate);
	}


	@Override
	public List<FlightDetails> getAllFlightDetails() {
		return fligthDetailsRepository.findAll();
	}


	@Override
	public List<FlightDetails> getOrderByDepartureTimeAsc() {
		return fligthDetailsRepository.findByOrderByDepartureTimeAsc();
	}


	@Override
	public List<FlightDetails> getOrderByDepartureTimeDesc() {
		return fligthDetailsRepository.findByOrderByDepartureTimeDesc();
	}


	@Override
	public List<FlightDetails> getOrderByDurationAsc() {
		return fligthDetailsRepository.findByOrderByDurationAsc();
	}


	@Override
	public List<FlightDetails> getOrderByDurationDesc() {
		return fligthDetailsRepository.findByOrderByDurationDesc();
	}
	
	@Override
	public List<FlightDetails> getOrderByAirlineNameAsc() {
		return fligthDetailsRepository.findByOrderByAirlineNameAsc();
	}


	@Override
	public List<FlightDetails> getOrderByAirlineNameDesc() {
		return fligthDetailsRepository.findByOrderByAirlineNameDesc();
	}
	
	@Override
	public List<FlightDetails> getOrderByPriceDesc() {
		return fligthDetailsRepository.findByOrderByPriceDesc();
	}
	
}
