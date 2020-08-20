package com.work.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight_details")
public class FlightDetails {
			
		@Id
		private Long id;
		
		@Column(name="flight_number")
		private String flightNumber;

		@Column(name="airline_name")
		private String airlineName;

		@Column(name="source_city")
		private String sourceCity;
		
		@Column(name="destination_city")
		private String destinationCity;
		
		@Column(name="travel_date")
		private LocalDate travelDate;
		
		@Column(name="return_date")
		private LocalDate returnDate;

		@Column(name="arrival_time")
		private LocalTime arrivalTime;
		
		@Column(name="departure_time")
		private LocalTime departureTime;

		@Column(name="duration")
		private float duration;
		
		@Column(name="number_of_stops")
		private Integer numberOfStops;	
		
		@Column(name="price")
		private Integer price;	

		@Column(name="toal_number_of_results")
		private Integer totalNumberOfResults;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}

		public String getAirlineName() {
			return airlineName;
		}

		public void setAirlineName(String airlineName) {
			this.airlineName = airlineName;
		}

		public String getSourceCity() {
			return sourceCity;
		}

		public void setSourceCity(String sourceCity) {
			this.sourceCity = sourceCity;
		}

		public String getDestinationCity() {
			return destinationCity;
		}

		public void setDestinationCity(String destinationCity) {
			this.destinationCity = destinationCity;
		}

		public LocalDate getTravelDate() {
			return travelDate;
		}

		public void setTravelDate(LocalDate travelDate) {
			this.travelDate = travelDate;
		}

		public LocalDate getReturnDate() {
			return returnDate;
		}

		public void setReturnDate(LocalDate returnDate) {
			this.returnDate = returnDate;
		}

		public LocalTime getArrivalTime() {
			return arrivalTime;
		}

		public void setArrivalTime(LocalTime arrivalTime) {
			this.arrivalTime = arrivalTime;
		}

		public LocalTime getDepartureTime() {
			return departureTime;
		}

		public void setDepartureTime(LocalTime departureTime) {
			this.departureTime = departureTime;
		}

		public float getDuration() {
			return duration;
		}

		public void setDuration(float duration) {
			this.duration = duration;
		}

		public Integer getNumberOfStops() {
			return numberOfStops;
		}

		public void setNumberOfStops(Integer numberOfStops) {
			this.numberOfStops = numberOfStops;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		public Integer getTotalNumberOfResults() {
			return totalNumberOfResults;
		}

		public void setTotalNumberOfResults(Integer totalNumberOfResults) {
			this.totalNumberOfResults = totalNumberOfResults;
		}	
		

}
