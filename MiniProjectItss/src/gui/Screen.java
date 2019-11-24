package gui;

public class Screen {
	
	public static void printStationSelectionScreen() {
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
		System.out.println("Available actions: 1-enter station, 2-exit station, type 'exit' to quit");
		System.out.println("Your input: ");
	}
	public static void printStationList() {
		System.out.println("These are existing tickets/cards:");
		System.out.println("\t•abcdefgh: One-way ticket between Chatelet and Olympiades: New –3.42 euros");
		System.out.println("\t•ijklmnop: 24h tickets: New");
		System.out.println("\t•ABCDEFGH: Prepaid card: 5.65 euros");
		System.out.println("\t•ponmlkji: 24h tickets: Valid until 14:35 -16th of May, 2019");
		System.out.println("Please provide the ticket code you want to enter/exit:\n");	
	}
	
}
