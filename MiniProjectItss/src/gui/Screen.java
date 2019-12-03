package gui;

import java.util.Scanner;

import config.Constants;
import controller.CardController;
import controller.Ticket24Controller;
import controller.TicketOwController;
import dao.ListTicketDAO;
import dto.ListTicketDTO;
import sdk.CScanner;
import sdk.Recognizer;

public class Screen {
	private static String stselect;
	private static String pseudo;
	private static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * Kiểm tra xâu mà người dùng nhập có đúng định dạng hay không
	 * @param input xâu mà người dùng nhập vào.
	 * @param pattern định dạng mà người dùng muốn so sánh.
	 * @return trả về true nếu xâu đúng định dạng và ngược lại
	 */
	private static boolean isAvailableAction(String input, String pattern) {
		return input.matches(pattern);
	}

	private static int checkPseudoCode(){
		if(pseudo.length()!=8) return -1;
		if(pseudo.equals(pseudo.toUpperCase())) return 1;
		else if(pseudo.equals(pseudo.toLowerCase())) return 0;
		else return -1;
	}
	
	public static void run() {
		try {
			do {
				Screen.printStationSelectionScreen();
				stselect = keyboard.nextLine().trim();
				while (!isAvailableAction(stselect,Constants.station_code_pattern) && !stselect.equals("exit")) {
					System.out.println("Unavailable action, please enter again:");
					stselect = keyboard.nextLine().trim();
				}
				if(stselect.equals("exit")) break;

				Screen.printTicketList();
				pseudo = keyboard.nextLine().trim();
				while (!isAvailableAction(pseudo,Constants.ticket_code_pattern)) {
					System.out.println("Wrong code, please enter code (8-bit) again:");
					pseudo = keyboard.nextLine().trim();
				}

				if(Screen.checkPseudoCode()==1) {
					CScanner scanner = new CScanner(pseudo);
					CardController cardcontrol = new CardController(scanner.getCode16bits());
					if(cardcontrol.getCard().getCard_id()!=null) {
						if(stselect.charAt(0)=='1') {
							cardcontrol.getInStation(stselect);
						}else if(stselect.charAt(0)=='2') {
							cardcontrol.getOutStation(stselect);
						}
					}else Message.printGetDatabaseError();
				}else if(Screen.checkPseudoCode()==0) {
					Recognizer rc = new Recognizer(pseudo);
					ListTicketDTO ticket = ListTicketDAO.getTicketType(rc.getCode16bits());
					if("ticket24h".equals(ticket.getType())) {
						Ticket24Controller tk24control = new Ticket24Controller(rc.getCode16bits());
						if(stselect.charAt(0)=='1') {
							tk24control.getInStation(stselect);
						}else if(stselect.charAt(0)=='2') {
							tk24control.getOutStation(stselect);
						}
					}else if("ticketoneway".equals(ticket.getType())){
						TicketOwController tkowcontrol = new TicketOwController(rc.getCode16bits());
						if(stselect.charAt(0)=='1') {
							tkowcontrol.getInStation(stselect);
						}else if(stselect.charAt(0)=='2') {
							tkowcontrol.getOutStation(stselect);
						}
					}else Message.printGetDatabaseError();
				}
			}while(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	   * Phương thức in ra màn hình console list các nhà ga
	   */
	private static void printStationSelectionScreen() {
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
	
	/**
	   * In ra màn hình console danh sách các mã pseudo code.
	   */
	private static void printTicketList() {
		System.out.println("These are existing tickets/cards:");
		System.out.println("\t•abcdefgh: One-way ticket between Chatelet and Olympiades: New –3.42 euros");
		System.out.println("\t•ijklmnop: 24h tickets: New");
		System.out.println("\t•ABCDEFGH: Prepaid card: 5.65 euros");
		System.out.println("\t•ponmlkji: 24h tickets: Valid until 14:35 -16th of May, 2019");
		System.out.println("Please provide the ticket code you want to enter/exit:\n");	
	}
}
