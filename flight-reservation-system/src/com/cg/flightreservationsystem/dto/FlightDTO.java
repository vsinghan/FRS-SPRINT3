package com.cg.flightreservationsystem.dto;

public class FlightDTO {
	 private String source;
	 private String destination;
	 private String date;
	 private String time;
	 private String price;

	
	public FlightDTO(String source, String destination, String date, String time, String price) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.price = price;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
