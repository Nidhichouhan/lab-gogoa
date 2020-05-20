package services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

// Type your code
public class FareCalculator extends Booking{
	Booking book=new Booking();
	
	public double book(Hotel hotel) {
		int persons=hotel.getNoOfPersons();
		int rates=hotel.getRates();
		String occupancy=hotel.getOccupancy();
		LocalDate fromdate=hotel.getFromdate();
		LocalDate todate=hotel.getTodate();
		double data=0.0;
		
		
		
		if(todate.isAfter(fromdate)) {
			int noOfDaysBetween=(int) ChronoUnit.DAYS.between(fromdate, todate);
			int totalfare=(persons*rates)*noOfDaysBetween;
			data=book.booking(persons, totalfare);
		}
		return data;
	}
	
	public double book(Flight flight) {
		int persons=flight.getNoOfPersons();
		int rates=flight.getRates();
		LocalDate fromdate=flight.getFrom();
		LocalDate todate=flight.getTo();
		String triptype=flight.getTriptype();
		double data=0.0;
		
		if(triptype=="One-Way") {
			data=book.booking(persons, rates);
		}
		
		if(todate.isAfter(fromdate)) {
			rates=rates*2;
			data=book.booking(persons, rates);
		}
		return data;
	}
	
	public double book(Train train) {
		
		int persons=train.getNoOfPersons();
		int rates=train.getRates();
		double data=book.booking(persons, rates);
		return data;
	}
	
	public double book(Bus bus) {
		int persons=bus.getNoOfPersons();
		int rates=bus.getRates();
		double data=book.booking(persons, rates);
		return data;
	}
}