package delegation;


public class Driver {
	
	public static void main(String[] args) {
		//Booking Train Ticket
		TicketBookingByAgent agentT = new TicketBookingByAgent(new TrainTicket());
		agentT.bookTicket();
		
		
		//Booking Flight Ticket
		TicketBookingByAgent agentF = new TicketBookingByAgent(new FlightTicket());
		agentF.bookTicket();
	}
	
	//Whenever now booking logic //bookTicket has to be changed it doesnot need to be changed in 
	//all classes but only in TicketBookingByAgent because now we delegated (responsibity) booking
	//Ticket responsibilty to this class.
	

}
