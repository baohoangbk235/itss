package gui;

import java.util.Scanner;

import controller.CardController;
import controller.Ticket24Controller;

public class Main {
	private static String stselect;
	private static String pseudo;
	private static Scanner keyboard = new Scanner(System.in);

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
			if(stselect.equals("exit")) break;
			Screen.printStationList();
			pseudo = keyboard.nextLine().trim();
			
			if(Main.checkPseudoCode()==1) {
				CScanner scanner = new CScanner(pseudo);
				CardController cardcontrol = new CardController(scanner.getCode16bits());
				if(stselect.charAt(0)=='1') {
					cardcontrol.getInStationCard(stselect);
				}else if(stselect.charAt(0)=='2') {
					cardcontrol.getOutStationCard(stselect);
				}
			}else if(Main.checkPseudoCode()==0) {
				Recognizer rc = new Recognizer(pseudo);
				Ticket24Controller tk24control = new Ticket24Controller(rc.getCode16bits());
				if(stselect.charAt(0)=='1') {
					tk24control.getInStationTk24(stselect);
				}else if(stselect.charAt(0)=='2') {
					tk24control.getOutStationTk24(stselect);
				}
			}}while(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
