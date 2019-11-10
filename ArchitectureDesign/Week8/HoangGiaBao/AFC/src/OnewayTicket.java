
import hust.soict.se.customexception.InvalidIDException;
import hust.soict.se.scanner.CardScanner;
import hust.soict.se.gate.Gate;
import hust.soict.se.recognizer.TicketRecognizer;
 
public class OnewayTicket {
	private int id;
	private int startStation;
	private int endStation;
	private int price;
	private String realeasedTime;
	private boolean status;
	
	static Gate gate = Gate.getInstance();
	
	public void checkTicketStatus() {
	}
	
	public int compareFare(int ticketFare, int transitionFare) {
		if (ticketFare < transitionFare)
			return -1;
		else if (ticketFare > transitionFare)
			return 1;
		else
			return 0;	
	}
	
	private float getTransitionFare(int startStationId, int endStationId) {
		int distance = 0;
		float fare = (float) (distance * 1.0);
		if (startStationId == endStationId) {
			System.out.println("Two station can not be the same\n");
			return 0;
		}
		if (distance > 0 && distance < 5) 
			fare = (float) 1.9;
		else {
			int additionalKm = (int) (distance % 2) + 1; 
			fare = (float) ((float) 1.9 + additionalKm * 0.4);
		}
		return fare;
	}
	
	
	public static void main(String[] args) throws InvalidIDException {
		// TODO Auto-generated method stub
		String pseudoBarCode1 = "abcdefgh";
		TicketRecognizer ticketRecognizer = TicketRecognizer.getInstance();
		String ticketId = ticketRecognizer.process(pseudoBarCode1);
		System.out.println(ticketId);
		
		OnewayTicket onewayTicket = new OnewayTicket();
		
		if (onewayTicket.status == false)
			gate.close();
//		gate.open();
		
	}

}
