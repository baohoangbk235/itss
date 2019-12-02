package gui;

import java.util.Scanner;

import controller.CardController;
import controller.Ticket24Controller;
import controller.TicketOwController;
import dao.ListTicketDAO;
import dto.ListTicketDTO;
import util.Constants;

public class Main {
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

	public static int checkPseudoCode(){
		if(pseudo.length()!=8) return -1;
		if(pseudo.equals(pseudo.toUpperCase())) return 1;
		else if(pseudo.equals(pseudo.toLowerCase())) return 0;
		else return -1;
	}
	public static void main(String[] args) {
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
				while (!isAvailableAction(pseudo,Constants.ticket_code_pattern) && !pseudo.equals("exit")) {
					System.out.println("Wrong code, please enter code (8-bit) again:");
					pseudo = keyboard.nextLine().trim();
				}


				if(Main.checkPseudoCode()==1) {
					CScanner scanner = new CScanner(pseudo);
					CardController cardcontrol = new CardController(scanner.getCode16bits());
					if(stselect.charAt(0)=='1') {
						cardcontrol.getInStation(stselect);
					}else if(stselect.charAt(0)=='2') {
						cardcontrol.getOutStation(stselect);
					}
				}else if(Main.checkPseudoCode()==0) {
					Recognizer rc = new Recognizer(pseudo);
					ListTicketDTO ticket = ListTicketDAO.getTicketType(rc.getCode16bits());
					if(ticket.getType().equals("ticket24h")) {
						Ticket24Controller tk24control = new Ticket24Controller(rc.getCode16bits());
						if(stselect.charAt(0)=='1') {
							tk24control.getInStation(stselect);
						}else if(stselect.charAt(0)=='2') {
							tk24control.getOutStation(stselect);
						}
					}else if(ticket.getType().equals("ticketoneway")){
						TicketOwController tkowcontrol = new TicketOwController(rc.getCode16bits());
						if(stselect.charAt(0)=='1') {
							tkowcontrol.getInStation(stselect);
						}else if(stselect.charAt(0)=='2') {
							tkowcontrol.getOutStation(stselect);
						}
					}else System.out.println("Card or ticket not exist !");
				}}while(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
