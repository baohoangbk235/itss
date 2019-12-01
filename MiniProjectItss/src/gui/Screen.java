package gui;

import java.sql.Timestamp;

public class Screen {
	/**
	   * Phương thức in ra màn hình console list các nhà ga
	   */
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
	
	/**
	   * In ra màn hình console danh sách các mã pseudo code.
	   */
	public static void printTicketList() {
		System.out.println("These are existing tickets/cards:");
		System.out.println("\t•abcdefgh: One-way ticket between Chatelet and Olympiades: New –3.42 euros");
		System.out.println("\t•ijklmnop: 24h tickets: New");
		System.out.println("\t•ABCDEFGH: Prepaid card: 5.65 euros");
		System.out.println("\t•ponmlkji: 24h tickets: Valid until 14:35 -16th of May, 2019");
		System.out.println("Please provide the ticket code you want to enter/exit:\n");	
	}
	
	/**
	   * In ra thông thông báo mở cổng, và các thông tin của ticket one-way hay card đã được sử dụng để đi qua.
	   * @param type Loại vé hay card
	   * @param id Mã định danh của vé/card
	   * @param balance Giá vé/số dư của thẻ
	   * @exception InterruptedException Ngoại lệ cho gate
	   */
	public static void printOpenMess(String type, String id, float balance) throws InterruptedException{
		GateInterface.open();
		System.out.println("Type: "+type+"\t\tId: "+id);
		System.out.println("Balance: "+balance);
		Screen.pressAnyKeyToContinue();
	}
	
	/**
	   * In ra thông thông báo mở cổng, và các thông tin của ticket 24h đã được sử dụng để đi qua.
	   * @param type Nên truyền vào chuỗi "Ticket 24h"
	   * @param id Mã định danh của vé/card
	   * @param valid Thời hạn của vé 24h
	   * @exception InterruptedException Ngoại lệ cho gate
	   */
	public static void printOpenMess(String type, String id, Timestamp valid) throws InterruptedException{
		GateInterface.open();
		System.out.println("Type: "+type+"\t\tId: "+id);
		System.out.println("Valid until: "+ valid);
		Screen.pressAnyKeyToContinue();
	}
	
	/**
	   * In ra thông thông báo lỗi khi giá mua ticket one-way hoặc số dư trong card nhỏ hơn giá hành trình.
	   * @param type Loại vé hay card
	   * @param id Mã định danh của vé/card
	   * @param balance Giá vé/số dư của thẻ
	   * @param fare Giá hành trình
	   */
	public static void printErrorMess(String type, String id, float balance, float fare) {
		System.out.println("Invalid "+type);
		System.out.println("Id: "+id+", balance: "+balance+" euros");
		System.out.println("Not enough balance: Expected "+fare+" euros");
		Screen.pressAnyKeyToContinue();
	}
	
	/**
	   * In ra thông thông báo mở cổng, và các thông tin của ticket 24h đã được sử dụng để đi qua.
	   * @param type Nên truyền vào chuỗi "Ticket 24h"
	   * @param id Mã định danh của vé 24h
	   * @param valid Thời hạn của vé 24h
	   * @param getin_time Thời gian vào cổng
	   */
	public static void printErrorMess(String type, String id, Timestamp valid, Timestamp getin_time) {
		System.out.println("Invalid "+type);
		System.out.println("Id: "+id+", valid until: "+valid);
		System.out.println("Expired: Try to enter at "+getin_time);
		Screen.pressAnyKeyToContinue();
	}
	
	/**
	   * In ra thông thông báo lỗi khi số dư trong thẻ nhỏ hơn 2.5 euros.
	   * @param id Mã định danh của card
	   * @param balance Số dư trong thẻ
	   */
	public static void printErrorMessCard(String id, float balance) {
		System.out.println("Invalid prepaid card");
		System.out.println("Id: "+id+", balance: "+balance+" euros");
		System.out.println("The balance is lower 2.5 euros");
		System.out.println("Please recharge to continue using");
		Screen.pressAnyKeyToContinue();
	}
	
	/**
	   * In ra thông thông báo lỗi khi người dùng nhập vào mã ticket one-way đã được sử dụng.
	   */
	public static void printErrorMessTkow() {
		System.out.println("Invalid one-way ticket");
		System.out.println("Invalid: This ticket have been used");
		Screen.pressAnyKeyToContinue();
	}
	
	/**
	   * In ra thông thông báo lỗi khi ticket one-way được sử dụng để vào hoặc ra một nhà ga nằm
	   * ngoài phạm vi 2 nhà ga được ghi trên vé.
	   * @param id Mã định danh của vé/card
	   * @param price Giá vé
	   * @param st1 Nhà ga thứ 1 được ghi trên vé
	   * @param st2 Nhà ga thứ 2 được ghi trên vé
	   * @param st Nhà ga mà vé được sử dụng để vào
	   */
	public static void printErrorMessTkow2(String id, float price, String st1, String st2, String st) {
		System.out.println("Invalid one-way ticket");
		System.out.println("Id: "+id+", balance: "+price+" euros");
		System.out.println("One-way ticket between "+st1+" and "+st2);
		System.out.println("Out of range: Try to enter station: "+ st);
		Screen.pressAnyKeyToContinue();
	}

	/**
	   * Press any key to continue
	   */
	 public static void pressAnyKeyToContinue(){ 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }

}
