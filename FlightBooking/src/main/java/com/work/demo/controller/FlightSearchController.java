package com.work.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.work.demo.entity.FlightDetails;
import com.work.demo.model.FlightDetailsModel;
import com.work.demo.repository.FlightDetailsRepository;
import com.work.demo.service.FlightDetailsService;

@RestController
@RequestMapping(path = "/flightsearch")
public class FlightSearchController {
	
	@Autowired
	FlightDetailsService flightDetailsService;

	@Autowired
	FlightDetailsRepository flightDetailsRepository;	
	
	@GetMapping(path= "/findBy")
	public FlightDetailsModel getFlightSearchDetails(@RequestParam String sourceCity, @RequestParam String destinationCity, @RequestParam String travelDate,@RequestParam String returnDate) {		
		List<FlightDetails> flightDetailList = flightDetailsService.getFlightSearchDetails(sourceCity, destinationCity, LocalDate.parse(travelDate), LocalDate.parse(returnDate));
		Comparator<FlightDetails> compareByPrice = (FlightDetails f1, FlightDetails f2) -> f1.getPrice().compareTo(f2.getPrice());
		Collections.sort(flightDetailList, compareByPrice);
		FlightDetailsModel flightDetailsModel = new FlightDetailsModel();		 
		flightDetailsModel.setFlightDetails(flightDetailList);		
		flightDetailsModel.setTotalRecords(flightDetailList.size());
		return flightDetailsModel;
	}
	
	@GetMapping(path= "/findAll")
	public List<FlightDetails> getFlightDetails(){		
		List<FlightDetails> flightDetailList = flightDetailsService.getAllFlightDetails(); 
		return flightDetailList;
	}

	@GetMapping(path= "/sortBy")
	public FlightDetailsModel sortByParam(@RequestParam String sortColumn, 
			@RequestParam String orderBy){
		List<FlightDetails> flightDetailList = new ArrayList<>();
		if(sortColumn.equals("departureTime")) {
			flightDetailList = (orderBy.equals("asc"))? 
					flightDetailsService.getOrderByDepartureTimeAsc() :
						  (orderBy.equals("desc")) ? flightDetailsService.getOrderByDepartureTimeDesc() : null;
		}else if(sortColumn.equals("duration")) {
			flightDetailList = (orderBy.equals("asc"))? 
					flightDetailsService.getOrderByDurationAsc() :
						  (orderBy.equals("desc")) ? flightDetailsService.getOrderByDurationDesc() : null;
		}else if(sortColumn.equals("airlineName")) {
			flightDetailList = (orderBy.equals("asc"))? 
					flightDetailsService.getOrderByAirlineNameAsc() :
						  (orderBy.equals("desc")) ? flightDetailsService.getOrderByAirlineNameDesc() : null;
		}else if(sortColumn.equals("price")) {
			flightDetailList = (orderBy.equals("desc"))? 
					flightDetailsService.getOrderByPriceDesc() :  null;
		}
		FlightDetailsModel flightDetailsModel = new FlightDetailsModel();
		flightDetailsModel.setFlightDetails(flightDetailList);
		flightDetailsModel.setTotalRecords(flightDetailList.size());
		return flightDetailsModel;
	}
	
	@GetMapping(path= "/removeDuplicateFlightNumber")
	public List<FlightDetails> getUniqueFlightDetails(){		
		List<FlightDetails> flightDetailList = flightDetailsService.getAllFlightDetails(); 
		List<FlightDetails> flightUniqueDetailSet = flightDetailList.stream().filter(distinctByKey(FlightDetails::getFlightNumber)).collect(Collectors.toList());
		return flightUniqueDetailSet;
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
	  {
	    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	  }

}
