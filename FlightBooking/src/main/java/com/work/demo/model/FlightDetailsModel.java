package com.work.demo.model;

import java.util.List;

import com.work.demo.entity.FlightDetails;

public class FlightDetailsModel {
		
		private List<FlightDetails> flightDetails;
		
		private int totalRecords;

		public List<FlightDetails> getFlightDetails() {
			return flightDetails;
		}

		public void setFlightDetails(List<FlightDetails> flightDetails) {
			this.flightDetails = flightDetails;
		}

		public int getTotalRecords() {
			return totalRecords;
		}

		public void setTotalRecords(int totalRecords) {
			this.totalRecords = totalRecords;
		}

}
