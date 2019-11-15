package gui;

import java.util.List;

import controller.CardController;
import controller.Ticket24Controller;
import controller.TicketOwController;
import dao.CardsDAO;
import dao.StationDAO;
import dao.Ticket24hDAO;
import dao.TicketOnewayDAO;
import dto.CardsDTO;
import dto.StationDTO;
import dto.Ticket24hDTO;
import dto.TicketOnewayDTO;
public class Main {


	public static void main(String[] args) {
		
		System.out.println("These are stations in the line M14 of Paris:");
		System.out.println("a. Saint-Lazare");
		System.out.println("b. Madeleine");
		System.out.println("c. Pyramides");
		System.out.println("d. Chatelet");
		System.out.println("e. Gare De Lyon");
		System.out.println("f. Bercy");
		System.out.println("g. Cour Saint-Emilion");
		System.out.println("h. Bibliotheque");
		System.out.println("i. Olympiades");
		System.out.println("Available actions: 1-enter station, 2-exit station");
		System.out.println("Your input: ");
		//input = scanIn.nextLine();
		//Code ben duoi chay de kiem tra ket noi database ok ko
		List<CardsDTO> list1 = CardController.getAll();
		List<Ticket24hDTO> list2 = Ticket24Controller.getAll();
		List<TicketOnewayDTO> list3 = TicketOwController.getAll();
		List<StationDTO> list4 = StationDAO.getAll();
		System.out.println("Card info:");
		for (CardsDTO c : list1) {
			System.out.println("id: "+c.getCard_id()+", released time: "+c.getRelease_time()+ ", balance: "+c.getBalance());
		}
		System.out.println("-----------------------------------------------------------");
		System.out.println("TK24h info:");
		for (Ticket24hDTO c : list2) {
			System.out.println("id: "+ c.getTk24_id()+", released time: "+c.getReleased_time()+", first use: "+c.getFirst_use()+", valid time: "+c.getValid_time()+ ", price: "+c.getPrice());
		}
		System.out.println("----------------------------------------------------------");
		System.out.println("Tk1w info:");
		for (TicketOnewayDTO c : list3) {
			System.out.println("id: "+c.getTkow_id()+", release_time: "+c.getReleased_time()+", price: "+c.getPrice()+", start station: "+c.getStart_station()+", exit station: "+c.getExit_station()+", status: "+c.getStatus());
		}
		System.out.println("----------------------------------------------------------");
		System.out.println("Check: Get card by id cv34567er0abcdef");
		CardsDTO c = CardsDAO.getCardById("cv34567er0abcdef");
		System.out.println("id: "+c.getCard_id()+", balance: "+c.getBalance()+ ", ownerid: "+c.getOwner_id());
		System.out.println("----------------------------------------------------------");
		System.out.println("Check: Get ticket24 by id bab1246b02772bb0");
		Ticket24hDTO t24 = Ticket24hDAO.getTk24ById("bab1246b02772bb0");
		System.out.println("id: "+ t24.getTk24_id()+", released time: "+t24.getReleased_time()+", first use: "+t24.getFirst_use()+", valid time: "+t24.getValid_time()+ ", price: "+t24.getPrice());
		System.out.println("----------------------------------------------------------");
		System.out.println("Check: Get ticket24 by id e8dc4081b13434b4");
		TicketOnewayDTO t1 = TicketOnewayDAO.getTkowById("e8dc4081b13434b4");
		System.out.println("id: "+t1.getTkow_id()+", release_time: "+t1.getReleased_time()+", price: "+t1.getPrice()+", start station: "+t1.getStart_station()+", exit station: "+t1.getExit_station()+", status: "+t1.getStatus());
		System.out.println("----------------------------------------------------------");
		System.out.println("List station & distance from first station:");
		for (StationDTO st : list4) {
			System.out.println("id: "+st.getSt_id()+", name: "+st.getSt_name()+ ", distance: "+st.getDistance());
		}
		//CardsDAO.update(list1.get(0));
	}
}
