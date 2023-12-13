package ie.lyit.testers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import ie.lyit.flight.*;

public class BookingTest {
	private Booking defaultBooking;
	private Booking noInboundBooking;
	private Booking fullBooking;
	private ArrayList<Passenger> noPassengers;
	private ArrayList<Passenger> onePassenger;
	private ArrayList<Passenger> twoPassengers;
	private Flight inboundFlight;
	
	@Before
	public void setUp() throws Exception{
		noPassengers = new ArrayList<Passenger>();
		onePassenger = new ArrayList<Passenger>();
		onePassenger.add(new Passenger(new Name("Mr","John","Doe"),"083 7563412","JoeBloggs@gmail.com",1,false,new CreditCard(1111222233334444L,new Date(31,12,2024),321)));
		twoPassengers = new ArrayList<Passenger>();
		twoPassengers.add(new Passenger(new Name("Mr","John","Doe"),"083 7563412","JohnDoe@gmail.com",1,false,new CreditCard(1111222233334444L,new Date(31,12,2024),321)));
		twoPassengers.add(new Passenger(new Name("Mrs","Jane","Doe"),"083 7563413","JaneDoe@gmail.com",1,false,new CreditCard(1111222233335555L,new Date(31,12,2025),476)));
		defaultBooking = new Booking();
		inboundFlight = new Flight("BA354","Dublin","Heathrow",new Date(1,1,2023),new Time(12,40), 20.00);
		noInboundBooking = new Booking(inboundFlight,onePassenger);
		fullBooking = new Booking(new Flight("BA354","Dublin","Heathrow",new Date(1,1,2023),new Time(12,40), 20.00),new Flight("BA454","Heathrow","Dublin",new Date(8,1,2023),new Time(9,40), 20.00),onePassenger);
	}
	
	@Test
	public void testBooking() {
		assertEquals("Booking number should be 10000",10000, defaultBooking.getBookingNumber());
	}

	@Test
	public void testFindPassenger() {
		assertEquals(true,noInboundBooking.findPassenger(new Passenger(new Name("Mr","John","Doe"),"083 7563412","JohnDoe@gmail.com",1,false,new CreditCard(1111222233334444L,new Date(31,12,2024),321))));
	}

}
