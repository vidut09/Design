package delegation;

public interface TicketBooking {
	
	public void bookTicket();

}

class TrainTicket implements TicketBooking{

	@Override
	public void bookTicket() {
		
		System.out.println("Train Ticket Booked ");
		
	}
	
}

class FlightTicket implements TicketBooking{

	@Override
	public void bookTicket() {
		
		System.out.println("Flight Ticket Booked ");
		
	}
}

// Delegated the responsibilty of booking ticket to this class 
class TicketBookingByAgent implements TicketBooking{
	TicketBooking t;
	
	public TicketBookingByAgent(TicketBooking t) {
		this.t = t;
		
	}

	@Override
	public void bookTicket() {
		
		t.bookTicket();
		
	}
}
