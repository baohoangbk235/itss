package gui;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import sdk.GateInterface;

public class Message {
	public static DecimalFormat df = new DecimalFormat("0.00");
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
		System.out.println("Balance: "+df.format(balance));
		Message.pressAnyKeyToContinue();
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
		Message.pressAnyKeyToContinue();
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
		System.out.println("Id: "+id+", balance: "+df.format(balance)+" euros");
		System.out.println("Not enough balance: Expected "+df.format(fare)+" euros");
		Message.pressAnyKeyToContinue();
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
		Message.pressAnyKeyToContinue();
	}
	
	/**
	   * In ra thông thông báo lỗi khi số dư trong thẻ nhỏ hơn 2.5 euros.
	   * @param id Mã định danh của card
	   * @param balance Số dư trong thẻ
	   */
	public static void printErrorMessCard(String id, float balance) {
		System.out.println("Invalid prepaid card");
		System.out.println("Id: "+id+", balance: "+df.format(balance)+" euros");
		System.out.println("The balance is lower 2.5 euros");
		System.out.println("Please recharge to continue using");
		Message.pressAnyKeyToContinue();
	}
	
	/**
	   * In ra thông thông báo lỗi khi người dùng nhập vào mã ticket one-way đã được sử dụng.
	   */
	public static void printErrorMessTkow() {
		System.out.println("Invalid one-way ticket");
		System.out.println("Invalid: This ticket have been used");
		Message.pressAnyKeyToContinue();
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
		System.out.println("Id: "+id+", balance: "+df.format(price)+" euros");
		System.out.println("One-way ticket between "+st1+" and "+st2);
		System.out.println("Out of range: Try to enter station: "+ st);
		Message.pressAnyKeyToContinue();
	}
	
	public static void printGetDatabaseError() {
		System.out.println("Error: Ticket/card does not exist in the database");
		Message.pressAnyKeyToContinue();
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
