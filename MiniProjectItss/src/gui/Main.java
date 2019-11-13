package gui;

import java.util.List;

import controller.CardController;
import controller.Ticket24Controller;
import controller.TicketOwController;
import dto.CardsDTO;
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
		List<CardsDTO> list1 = CardController.getAll();
		List<Ticket24hDTO> list2 = Ticket24Controller.getAll();
		List<TicketOnewayDTO> list3 = TicketOwController.getAll();
		System.out.println("Card info:");
		for (CardsDTO c : list1) {
			System.out.println("id: "+c.getCard_id()+", balance: "+c.getBalance());
		}
		System.out.println("----------------------------");
		System.out.println("TK24h info:");
		for (Ticket24hDTO c : list2) {
			System.out.println("id: "+c.getTk24_id()+", price: "+c.getPrice());
		}
		System.out.println("-----------------------------");
		System.out.println("Tk1w info:");
		for (TicketOnewayDTO c : list3) {
			System.out.println("id: "+c.getTkow_id()+", release_time: "+c.getReleased_time());
		}
	}
}
