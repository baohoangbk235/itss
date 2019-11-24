package gui;
import java.sql.Timestamp;
import java.util.Scanner;

import controller.CardController;
import dao.CardsDAO;
import dao.PassHistoryDAO;
import dto.PassHistoryDTO;

public class Screen {
	private static String stselect;
	private static String pseudo;
	private static Scanner keyboard = new Scanner(System.in);
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
		System.out.println("Available actions: 1-enter station, 2-exit station");
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
	public static int checkPseudoCode(){
		if(pseudo.length()!=8) return -1;
		if(pseudo.equals(pseudo.toUpperCase())) return 1;
		else if(pseudo.equals(pseudo.toLowerCase())) return 0;
		else return -1;
	}
	public static void main(String[] args) {
		try {
			Screen.printStationSelectionScreen();
			stselect = keyboard.nextLine().trim();
			Screen.printStationList();
			pseudo = keyboard.nextLine().trim();
			if(Screen.checkPseudoCode()==1) {
				CScanner scanner = new CScanner(pseudo);
				CardController cardcontrol = new CardController(scanner.getCode16bits());
				if(stselect.charAt(0)=='1') {
					if(cardcontrol.checkBalance()) {
						cardcontrol.setEnterpoint(String.valueOf(stselect.charAt(2)));
						PassHistoryDTO ph = new PassHistoryDTO(cardcontrol.getId(),cardcontrol.getEnterpoint());
						PassHistoryDAO.insertPassHistory(ph);
						GateInterface.open();
					}else {
						System.out.println("So du tai khoan khong du");
					}
				}else if(stselect.charAt(0)=='2') {
					PassHistoryDTO ph = PassHistoryDAO.getInfoById(cardcontrol.getId());
					cardcontrol.setEnterpoint(ph.getGetin_point());
					cardcontrol.setExitpoint(String.valueOf(stselect.charAt(2)));
					double fare = cardcontrol.caculateTripFare(cardcontrol.caculateDistance());
					double balance = cardcontrol.getCard().getBalance();
					if(cardcontrol.checkBalance(fare,balance)) {
						cardcontrol.getCard().setBalance((float)(balance-fare));
						ph.setFare((float)fare);
						ph.setGetout_point(cardcontrol.getExitpoint());
						ph.setGetout_time(new Timestamp(System.currentTimeMillis()));
						ph.setStatus(0);
						PassHistoryDAO.updatePassHistoryById(ph);
						CardsDAO.updateCard(cardcontrol.getCard());
						GateInterface.open();
					}else {
						System.out.println("Khong du tien yeu cau nap them");
					}
				}
			}else if(Screen.checkPseudoCode()==0) {
				Recognizer rc = new Recognizer(pseudo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
