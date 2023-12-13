package ie.lyit.flight;

import java.util.ArrayList;


public class Booking {
	private Flight outbound, inbound;
	private ArrayList<Passenger> passengers;
	private double totalPrice;
	private int bookingNo;
	private static int nextUniqueBookingNumber = 10000;
	
	public Booking() {
		outbound = new Flight();
		inbound = null;
		passengers = new ArrayList<Passenger>();
		passengers.add(new Passenger());
		totalPrice = 0;
		bookingNo = nextUniqueBookingNumber++;
	}
	
	public Booking(Flight oF, ArrayList<Passenger> p) throws Exception {
		outbound = oF;
		inbound = null;
		if(p.size()>1 || p.size()<10)
			passengers = p;
		else
			throw new Exception("There must be at least 1 passenger and less than 10");
		totalPrice = calculatePrice();
		bookingNo = nextUniqueBookingNumber++;
	}
	
	public Booking(Flight oF, Flight iF, ArrayList<Passenger> p) throws Exception {
		outbound = oF;
		inbound = iF;
		if(p.size()>1 || p.size()<10)
			passengers = p;
		else
			throw new Exception("There must be at least 1 passenger and less than 10");
		totalPrice = calculatePrice();
		bookingNo = nextUniqueBookingNumber++;
	}
	
	public String toString() {
		if(inbound != null)
			return "BOOKING NUMBER "+getBookingNumber()+"\nOUTBOUND FLIGHT "+getOutboundFlight()+"\nINBOUND FLIGHT"+getInboundFlight()+"\nPASSENGERS "+passengers.toString()+"\nTOTAL PRICE €"+getTotalPrice(); 
		return "BOOKING NUMBER "+getBookingNumber()+"\nOUTBOUND FLIGHT "+getOutboundFlight()+"\nPASSENGERS "+passengers.toString()+"\nTOTAL PRICE €"+getTotalPrice();
	}
	
	public boolean equals(Object obj) {
		Booking check;
	   	if (obj instanceof Booking)
	   		check = (Booking)obj;
	   	else
	   		return false;

	   return this.bookingNo == check.bookingNo;					
	}
	
	
	public int getBookingNumber() {
		return bookingNo;
	}
	
	public Flight getOutboundFlight() {
		return outbound;
	}
	
	public void setOutboundFlight(Flight outbound) {
		this.outbound = outbound;
	}
	
	public Flight getInboundFlight() {
		return inbound;
	}
	
	public void setInboundFlight(Flight inbound) {
		this.inbound = inbound;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice() {
		this.totalPrice = calculatePrice();
	}
	
	public boolean findPassenger(Passenger p) {
		for(Passenger passenger: passengers)
			if(passenger.equals(p))
				return true;
		return false;
	}
	
	public double calculatePrice() {
		double price;
		if(inbound != null)
		{
			price = inbound.getPrice() + outbound.getPrice();
			price = price * passengers.size();
		}
		else
		{
			price = outbound.getPrice() * passengers.size();
		}
		return price;
	}
}
