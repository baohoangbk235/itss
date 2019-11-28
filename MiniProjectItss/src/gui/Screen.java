package gui;

import java.sql.Timestamp;

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
	
	public static void printTicketList() {
		System.out.println("These are existing tickets/cards:");
		System.out.println("\t•abcdefgh: One-way ticket between Chatelet and Olympiades: New –3.42 euros");
		System.out.println("\t•ijklmnop: 24h tickets: New");
		System.out.println("\t•ABCDEFGH: Prepaid card: 5.65 euros");
		System.out.println("\t•ponmlkji: 24h tickets: Valid until 14:35 -16th of May, 2019");
		System.out.println("Please provide the ticket code you want to enter/exit:\n");	
	}
	
	public static void printOpenMess(String type, String id, float balance) throws InterruptedException{
		GateInterface.open();
		System.out.println("Type: "+type+"\t\tId: "+id);
		System.out.println("Balance: "+balance);
		System.out.println("Press any key to continue...");
	}
	
	public static void printOpenMess(String type, String id, Timestamp valid) throws InterruptedException{
		GateInterface.open();
		System.out.println("Type: "+type+"\t\tId: "+id);
		System.out.println("Valid until: "+ valid);
		System.out.println("Press any key to continue...");
	}
	
	public static void printErrorMess(String type, String id, float balance, float fare) {
		System.out.println("Invalid "+type);
		System.out.println("Id: "+id+", balance: "+balance+" euros");
		System.out.println("Not enough balance: Expected "+fare+" euros");
		System.out.println("Press any key to continue...");
	}
	
	public static void printErrorMess(String type, String id, Timestamp valid, Timestamp getin_time) {
		System.out.println("Invalid "+type);
		System.out.println("Id: "+id+", valid until: "+valid);
		System.out.println("Expired: Try to enter at "+getin_time);
		System.out.println("Press any key to continue...");
	}
	
	public static void printErrorMessCard(String id, float balance) {
		System.out.println("Invalid prepaid card");
		System.out.println("Id: "+id+", balance: "+balance+" euros");
		System.out.println("The balance is lower 2.5 euros");
		System.out.println("Please recharge to continue using");
		System.out.println("Press any key to continue...");
	}
	
	public static void printErrorMessTkow() {
		System.out.println("Invalid one-way ticket");
		System.out.println("Invalid: This ticket have been used");
		System.out.println("Press any key to continue...");
	}
	
	public static void printErrorMessTkow2(String id, float price, String st1, String st2, String st) {
		System.out.println("Invalid one-way ticket");
		System.out.println("Id: "+id+", balance: "+price+" euros");
		System.out.println("One-way ticket between "+st1+" and "+st2);
		System.out.println("Out of range: Try to enter station: "+ st);
		System.out.println("Press any key to continue...");
	}


}
