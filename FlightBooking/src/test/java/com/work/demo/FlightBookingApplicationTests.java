package com.work.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.work.demo.controller.FlightSearchController;
import com.work.demo.entity.FlightDetails;
import com.work.demo.service.FlightDetailsService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
class FlightBookingApplicationTests {
	
		@Mock
		public FlightDetailsService flightDetailServiceMock;
		
		@InjectMocks
		FlightSearchController flightSearchController;
		
		FlightDetails result = new FlightDetails();
		
		@Before
		public void before() {
			result.setFlightNumber("SJ3000");
			result.setAirlineName("SpiceJet");
			result.setDepartureTime(LocalTime.of(6,10,35));
			result.setArrivalTime(LocalTime.of(8,10,35));
			result.setDuration(2);
			result.setPrice(2000);
		}
		
		@Test
		public void getFlightDetailsTest() throws Exception{
			String sourceCity = "Chennai";
			String destinationCity = "Madurai";
			LocalDate travelDate = LocalDate.of(2020,8,12);
			LocalDate returnDate = LocalDate.of(2020,8,12);
			List<FlightDetails> detail = new ArrayList<FlightDetails>();
			detail.add(result);
			when(flightDetailServiceMock.getFlightSearchDetails(sourceCity,destinationCity, travelDate, returnDate)).thenReturn(detail);
			assertEquals(detail, flightSearchController.getFlightSearchDetails(sourceCity,destinationCity, "2020-08-12", "2020-08-12").getFlightDetails());
			Mockito.verify(flightDetailServiceMock, times(1)).getFlightSearchDetails(sourceCity,destinationCity, travelDate, returnDate);
		}
		
		@Test
		public void getOrderByDepartureTimeAsc() {
			String sortColumn = "departureTime";
			String orderBy = "asc";
			List<FlightDetails> detail = new ArrayList<FlightDetails>();
			detail.add(result);
			when(flightDetailServiceMock.getOrderByDepartureTimeAsc()).thenReturn(detail);
			assertEquals(detail, flightSearchController.sortByParam(sortColumn,orderBy).getFlightDetails());
			Mockito.verify(flightDetailServiceMock, times(1)).getOrderByDepartureTimeAsc();
		}
		
		@Test
		public void getOrderByDepartureTimeDesc() {
			String sortColumn = "departureTime";
			String orderBy = "desc";
			List<FlightDetails> detail = new ArrayList<FlightDetails>();
			detail.add(result);
			when(flightDetailServiceMock.getOrderByDepartureTimeDesc()).thenReturn(detail);
			assertEquals(detail, flightSearchController.sortByParam(sortColumn,orderBy).getFlightDetails());
			Mockito.verify(flightDetailServiceMock, times(1)).getOrderByDepartureTimeDesc();
		}
		
		@Test
		public void getOrderByAirlineNameAsc() {
			String sortColumn = "airlineName";
			String orderBy = "asc";
			List<FlightDetails> detail = new ArrayList<FlightDetails>();
			detail.add(result);
			when(flightDetailServiceMock.getOrderByAirlineNameAsc()).thenReturn(detail);
			assertEquals(detail, flightSearchController.sortByParam(sortColumn,orderBy).getFlightDetails());
			Mockito.verify(flightDetailServiceMock, times(1)).getOrderByAirlineNameAsc();
		}
		
		@Test
		public void getOrderByAirlineNameDesc() {
			String sortColumn = "airlineName";
			String orderBy = "desc";
			List<FlightDetails> detail = new ArrayList<FlightDetails>();
			detail.add(result);
			when(flightDetailServiceMock.getOrderByAirlineNameDesc()).thenReturn(detail);
			assertEquals(detail, flightSearchController.sortByParam(sortColumn,orderBy).getFlightDetails());
			Mockito.verify(flightDetailServiceMock, times(1)).getOrderByAirlineNameDesc();
		}
		
		@Test
		public void getOrderByDurationAsc() {
			String sortColumn = "duration";
			String orderBy = "asc";
			List<FlightDetails> detail = new ArrayList<FlightDetails>();
			detail.add(result);
			when(flightDetailServiceMock.getOrderByDurationAsc()).thenReturn(detail);
			assertEquals(detail, flightSearchController.sortByParam(sortColumn,orderBy).getFlightDetails());
			Mockito.verify(flightDetailServiceMock, times(1)).getOrderByDurationAsc();
		}
		
		@Test
		public void getOrderByDurationDesc() {
			String sortColumn = "duration";
			String orderBy = "desc";
			List<FlightDetails> detail = new ArrayList<FlightDetails>();
			detail.add(result);
			when(flightDetailServiceMock.getOrderByDurationDesc()).thenReturn(detail);
			assertEquals(detail, flightSearchController.sortByParam(sortColumn,orderBy).getFlightDetails());
			Mockito.verify(flightDetailServiceMock, times(1)).getOrderByDurationDesc();
		}
		
}
