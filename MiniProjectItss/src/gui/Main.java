package gui;

import java.util.ArrayList;

import controller.CardController;
import dto.CardsDTO;
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
		ArrayList<CardsDTO> cd = CardController.cardsAll();
		for (CardsDTO c : cd) {
			System.out.println(c.getCard_id());
		}
	}
}
