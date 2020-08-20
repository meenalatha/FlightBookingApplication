package com.work.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.demo.entity.FlightDetails;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails,Long>{
	
	List<FlightDetails> findBySourceCityAndDestinationCityAndTravelDateAndReturnDate(String sourceCity, String destinationCity,LocalDate travelDate, LocalDate returnDate);
	
	List<FlightDetails> findByOrderByDepartureTimeAsc();
	
	List<FlightDetails> findByOrderByDepartureTimeDesc();
	
	List<FlightDetails> findByOrderByDurationAsc();
	
	List<FlightDetails> findByOrderByDurationDesc();
	
	List<FlightDetails> findByOrderByAirlineNameAsc();
	
	List<FlightDetails> findByOrderByAirlineNameDesc();

	List<FlightDetails> findByOrderByPriceDesc();

}
